package com.teamdae.certificates.service.impl;

import com.teamdae.certificates.dto.Company;
import com.teamdae.certificates.dto.CompanyDTO;
import com.teamdae.certificates.dto.request.AddCompanyRequest;
import com.teamdae.certificates.persistence.entity.CompanyEntity;
//import com.teamdae.certificates.persistence.entity.CompanyViewEntity;
//import com.teamdae.certificates.persistence.repository.CompanyViewRepository;
import com.teamdae.certificates.persistence.repository.RepositoryService;
import com.teamdae.certificates.persistence.repository.CompanyRepository;
import com.teamdae.certificates.service.CompanyService;
import com.teamdae.certificates.utils.ConvertUtils;
import com.teamdae.certificates.utils.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final RepositoryService repositoryService;
    private final SequenceGenerator sequenceGenerator;
    private final CompanyRepository companyRepository;
//    private final CompanyViewRepository companyViewRepository;


    @Autowired
    public CompanyServiceImpl(RepositoryService repositoryService, SequenceGenerator sequenceGenerator, CompanyRepository companyRepository) {
        this.repositoryService = repositoryService;
        this.sequenceGenerator = sequenceGenerator;
        this.companyRepository = companyRepository;
//        this.companyViewRepository = companyViewRepository;
    }

    @Override
    public List<CompanyDTO> findAllCompanies() {
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyEntities.stream()
                .map(this::mapToCompanyDTO)
                .collect(Collectors.toList());
    }

    private CompanyDTO mapToCompanyDTO(CompanyEntity entity) {
        return CompanyDTO.builder()
                .companyName(entity.getCompanyName())
                .id(Long.valueOf(entity.getId()))
                .build();
    }


    @Override
    public Company findCompanyById(Integer id) {
        return ConvertUtils.convertToCompanies(repositoryService.findCompanyById(id));
    }


    @Override
    public Company addCompany(AddCompanyRequest addCompanyRequest) {
        CompanyEntity companyEntity = CompanyEntity.builder()
                .fiscalCode(addCompanyRequest.getFiscalCode())
                .companyName(addCompanyRequest.getCompanyName())
                .description(addCompanyRequest.getDescription())
                .tenantOrg(addCompanyRequest.getTenantOrg())
                .lastModified(LocalDateTime.now())
                .build();
        return ConvertUtils.convertToCompanies(repositoryService.saveCompany(companyEntity));
    }

//    @Override
//    public String removeCompany(Integer id) {
//        CompanyEntity companyEntity = repositoryService.findCompanyById(id);
//        repositoryService.deleteCompany(companyEntity);
//        return "Successfully deleted company with id:" + id;
//    }

    @Override
    public String removeCompany(Integer id) {
        CompanyEntity company = repositoryService.findCompanyById(id);
        if (company != null) {
            companyRepository.deleteById(id);
            return "Company successfully removed";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company with id:" + id + " not found");
        }
    }

}
