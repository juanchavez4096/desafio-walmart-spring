package com.spring.walmart.desafio.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionInfoJson {
    private String path;
    private String message;
    private Integer status;
    private String exception;
}
