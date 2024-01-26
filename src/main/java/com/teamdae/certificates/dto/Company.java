package com.teamdae.certificates.dto;

//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Response body for company")
public class Company implements Serializable {

    @NotNull
    private String fiscalCode;

    @NotNull
    private String companyName;

    @NotNull
    private String description;

    @NotNull
    private String tenant_org;

    @NotNull
    private LocalDateTime timestamp;

}
