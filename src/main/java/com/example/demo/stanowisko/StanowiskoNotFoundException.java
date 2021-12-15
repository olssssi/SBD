package com.example.demo.stanowisko;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StanowiskoNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public StanowiskoNotFoundException() {}
}
