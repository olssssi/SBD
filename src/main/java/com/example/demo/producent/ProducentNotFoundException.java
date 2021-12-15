package com.example.demo.producent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProducentNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ProducentNotFoundException() {}
}
