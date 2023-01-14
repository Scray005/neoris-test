package com.test.neoris.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonIgnoreProperties
public class ResponseDto<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
}
