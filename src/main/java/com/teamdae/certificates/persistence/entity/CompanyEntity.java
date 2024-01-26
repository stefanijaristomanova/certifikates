package com.teamdae.certificates.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company", catalog = "certifika", schema = "certifika")
public class CompanyEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3343003280979161263L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id; // or Long?

    @Column(name = "tenant_org", nullable = false)
    private String tenantOrg;

    @Column(name = "last_modified", nullable = false)
    private LocalDateTime lastModified;

    @Column(name = "last_modified_by", length = 120)
    private String lastModifiedBy;

    @Column(name = "vat_id", length = 60)
    private String vatId;

    @Column(name = "fiscal_code", length = 60)
    private String fiscalCode;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "description", length = 2048)
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hq_address_id")
//    private CompanySiteEntity hqAddress;

    @Column(name = "website", length = 120)
    private String website;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_type")
//    private DataPoolEntity companyType;

}