package com.br.bufalo.template.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RestErrorModel {
    private String errorMessage;
    private Date errorTime;

    public RestErrorModel(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorTime = new Date();
    }

}
