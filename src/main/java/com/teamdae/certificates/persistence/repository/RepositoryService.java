package com.teamdae.certificates.persistence.repository;

import com.teamdae.certificates.persistence.entity.CompanyEntity;
//import com.teamdae.certificates.persistence.entity.CompanyViewEntity;

import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RepositoryService {

    private CompanyRepository companyRepository;
//    private CompanyViewRepository companyViewRepository;

//    @Autowired
//    public RepositoryService(CompanyRepository companyRepository, CompanyViewRepository companyViewRepository) {
//        this.companyRepository = companyRepository;
//        this.companyViewRepository = companyViewRepository;
//    }

    @Autowired
    public RepositoryService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }


//    public void saveAllCompanies(List<CompanyEntity> companyEntities) {
//        try {
//            companyRepository.saveAll(companyEntities);
//        } catch (Exception exception) {
//            throw new ResponseStatusException(
//                    HttpStatus.INTERNAL_SERVER_ERROR,
//                    ExceptionUtils.getRootCauseMessage(exception.getCause()));
//        }
//    }

    public CompanyEntity findCompanyById(Integer id) {
        return companyRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Company with id:" + id + " not found"));
    }

    public CompanyEntity saveCompany(CompanyEntity companyEntity) {
        try {
             return companyRepository.save(companyEntity);
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    ExceptionUtils.getRootCauseMessage(exception.getCause()));
        }
    }

    public void deleteCompany(CompanyEntity companyEntity) {
        try {
            companyRepository.delete(companyEntity);
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error while deleting data from database on record with ID: " + companyEntity.getId());
        }
    }
}
