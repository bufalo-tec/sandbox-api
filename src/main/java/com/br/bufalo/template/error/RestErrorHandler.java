package com.br.bufalo.template.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RestErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<RestErrorModel> handleRestException(CustomException rse) {
        log.error("CustomException", rse);
        RestErrorModel restErrorModel = new RestErrorModel(rse.getErrorMessage().orElse("No additional details"));
        return new ResponseEntity<>(restErrorModel, rse.getStatus());
    }
}
