package com.teamdae.certificates.service;

import com.teamdae.certificates.dto.Company;
import com.teamdae.certificates.dto.CompanyDTO;
import com.teamdae.certificates.dto.request.AddCompanyRequest;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAllCompanies();

    Company findCompanyById(Integer id);

    Company addCompany(AddCompanyRequest addCompanyRequest);

    String removeCompany(Integer id);
}
