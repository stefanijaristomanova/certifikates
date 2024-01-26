package com.teamdae.certificates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyResponseDTO {
    private List<CompanyItemDTO> data;

    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class CompanyItemDTO {
        private List<String> iafCodes;
        private String companyName;
        private Long id;
    }
}
