package org.devjeans.sid.domain.auth.entity;

import lombok.Data;

@Data
public class KakaoRedirect {
    private String code;
    private String error;
    private String error_description;
    private String state;
}
