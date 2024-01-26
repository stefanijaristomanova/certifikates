package com.teamdae.certificates.dto.response;

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
public class ListCompanyResponse {
    private List<CompanyItem> data;

    @SuperBuilder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class CompanyItem {
        private List<String> iafCodes;
        private String companyName;
        private Long id;
    }
}
