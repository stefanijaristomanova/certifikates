package com.teamdae.certificates.persistence.repository;

import com.teamdae.certificates.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

}