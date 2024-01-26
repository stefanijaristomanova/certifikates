package com.teamdae.certificates.utils;

import com.teamdae.certificates.dto.Company;
import com.teamdae.certificates.persistence.entity.CompanyEntity;
//import com.teamdae.certificates.persistence.entity.CompanyViewEntity;


public class ConvertUtils {

    public static Company convertToCompanies(CompanyEntity companyEntity) {
        ModelMapperUtils modelMapper = new ModelMapperUtils();

        return modelMapper.map(companyEntity, Company.class);
    }

//    public static Company convertToCompaniesView(CompanyViewEntity companyViewEntity) {
//        ModelMapperUtils modelMapper = new ModelMapperUtils();
//
//        return modelMapper.map(companyViewEntity, Company.class);
//    }
}
