package com.teamdae.certificates.controller;

import com.teamdae.certificates.dto.Company;
import com.teamdae.certificates.dto.CompanyDTO;
import com.teamdae.certificates.dto.response.ApiCompanyResponse;
import com.teamdae.certificates.dto.request.AddCompanyRequest;
import com.teamdae.certificates.dto.response.ListCompanyResponse;
import com.teamdae.certificates.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("v1/company-service/company")
@Api(value = "Providing operations for the company entity")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ApiOperation(value = "Find all companies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Companies successfully found"),
            @ApiResponse(code = 500, message = "Internal server error while fetching all companies")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApiCompanyResponse<ListCompanyResponse>> findAllCompanies() {
        List<CompanyDTO> companyDTOs = companyService.findAllCompanies();

        ListCompanyResponse listCompanyResponse = ListCompanyResponse.builder()
                .data(companyDTOs.stream().map(this::mapToCompanyItem).collect(Collectors.toList()))
                .build();

        ApiCompanyResponse<ListCompanyResponse> apiResponse = ApiCompanyResponse.of(HttpStatus.OK.value(), listCompanyResponse);

        return ResponseEntity.ok(apiResponse);
    }


    private ListCompanyResponse.CompanyItem mapToCompanyItem(CompanyDTO companyDTO) {
        return ListCompanyResponse.CompanyItem.builder()
                .iafCodes(companyDTO.getIafCodes()) // Assuming getIafCodes() returns a List<String>
                .companyName(companyDTO.getCompanyName())
                .id(companyDTO.getId())
                .build();
    }


    @ApiOperation(value = "Find a company by id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Company successfully found"),
            @ApiResponse(code = 404, message = "The company you were trying to retrieve was not found")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Company> findCompanyById(@PathVariable Integer id) {
        Company response = companyService.findCompanyById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Remove a company ", response = ResponseEntity.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Company successfully removed"), @ApiResponse(code = 500, message = "Problem while removing the company")})
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> removeCompany(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(companyService.removeCompany(id));
    }


    @ApiOperation(value = "Add a company", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Company successfully created"),
            @ApiResponse(code = 500, message = "Problem while creating the company")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Company> addCompany(@Valid @RequestBody AddCompanyRequest addCompanyRequest) {

        Company response = companyService.addCompany(addCompanyRequest);
        if (response != null) {
            return ResponseEntity.created(URI.create("")).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Company.builder().build());
        }
    }

}
