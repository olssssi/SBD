package com.example.demo.faktura;

import com.example.demo.towar.TowarNotFoundException;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/faktury")
public class FakturaController {
    private final FakturaService fakturaService;

    @Autowired
    public FakturaController(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Faktura>> getFaktury() {
        return new ResponseEntity<>(fakturaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/zamowienia/{id}")
    public ResponseEntity<List<Zamowienie>> getZamowienia(@PathVariable Long id) throws FakturaNotFoundException {
        Faktura faktura = fakturaService.findById(id);
        return new ResponseEntity<>(new ArrayList<>(fakturaService.getZamowienia(faktura)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faktura> getFaktura(@PathVariable Long id) throws FakturaNotFoundException {
        return new ResponseEntity<>(fakturaService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/oplacona/{id}")
    public ResponseEntity<HttpStatus> setFakturaPaid(@PathVariable Long id) throws FakturaNotFoundException, ZamowienieNotFoundException, TowarNotFoundException {
        Faktura faktura = fakturaService.findById(id);
        fakturaService.registerAsPaid(faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Faktura> addFaktura(@RequestBody Faktura faktura) {
        return new ResponseEntity<>(fakturaService.save(faktura),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeFaktura(@PathVariable Long id) throws FakturaNotFoundException {
        fakturaService.delete(fakturaService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}