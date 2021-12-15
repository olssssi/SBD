package com.example.demo.pozycja;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PozycjaNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public PozycjaNotFoundException() {}
}
