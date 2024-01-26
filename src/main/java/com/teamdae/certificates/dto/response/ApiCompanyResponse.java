package com.teamdae.certificates.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiCompanyResponse<T> {
    private Status status;
    private T body;

    public ApiCompanyResponse(Status status, T body) {
        this.status = status;
        this.body = body;
    }

    public static class Status {
        private int code;

        public Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public static <T> ApiCompanyResponse<T> of(int statusCode, T body) {
        return new ApiCompanyResponse<>(new Status(statusCode), body);
    }
}
