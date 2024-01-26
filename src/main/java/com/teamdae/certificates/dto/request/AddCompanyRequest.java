package com.teamdae.certificates.dto.request;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddCompanyRequest implements Serializable {

    static final long serialVersionUID = 1L;

    @NotNull
    private String fiscalCode;

    @NotNull
    private String companyName;

    @NotNull
    private String description;

    @NotNull
    private String tenantOrg;

    @NotNull
    private LocalDateTime timestamp;

}