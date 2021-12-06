package com.example.demo;

import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikService;
import com.example.demo.stanowisko.Stanowisko;
import com.example.demo.stanowisko.StanowiskoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InitController {
    private final PracownikService pracownikService;
    private final StanowiskoService stanowiskoService;


    @Autowired
    public InitController(PracownikService pracownikService, StanowiskoService stanowiskoService) {
        this.pracownikService = pracownikService;
        this.stanowiskoService = stanowiskoService;
    }

    @GetMapping("/init")
    public ResponseEntity<List<Pracownik>> getPracownicy() {
        Stanowisko stanowisko = new Stanowisko("Magazynier");
        stanowiskoService.save(stanowisko);
        Pracownik pracownik = new Pracownik("Anna", "Kowalska", "502365254", stanowisko);
        pracownikService.save(pracownik);
        return new ResponseEntity<>(pracownikService.findAll(), HttpStatus.OK);
    }
}
