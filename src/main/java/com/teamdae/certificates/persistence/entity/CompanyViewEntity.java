//package com.teamdae.certificates.persistence.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "company_view", schema = "certifika")
//public class CompanyViewEntity implements Serializable {
//
//    private static final long serialVersionUID = 3343003280979161263L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID", unique = true, nullable = false)
//    private Long id;
//
//    @Column(name = "DATE_ENTERED")
//    private LocalDateTime dateCreated;
//
//    @Column(name = "DELETED")
//    private Integer deleted;
//
//    @Column(name = "FIRSTNAME")
//    private String firstname;
//
//    @Column(name = "LASTNAME")
//    private String lastname;
//
//    @Column(name = "EMAIL", unique = true, nullable = false)
//    private String email;
//
//}
//
