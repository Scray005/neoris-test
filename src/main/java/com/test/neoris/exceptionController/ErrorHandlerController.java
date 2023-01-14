package com.test.neoris.exceptionController;

import com.test.neoris.exception.TryExeception;
import com.test.neoris.models.ResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(TryExeception.class)
    public ResponseDto<Object> validationFilds(TryExeception e) {
        return ResponseDto.builder()
                .code(401)
                .data(e.getMessage())
                .build();
    }
}
