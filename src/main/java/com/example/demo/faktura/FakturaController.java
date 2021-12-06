package com.example.demo.faktura;

import com.example.demo.exceptions.FakturaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ceny")
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

    @GetMapping("/{id}")
    public ResponseEntity<Faktura> getFaktura(@PathVariable Long id) throws FakturaNotFoundException {
        return new ResponseEntity<>(fakturaService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addFaktura(@RequestBody Faktura faktura) {
        fakturaService.save(faktura);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateFaktura(@PathVariable Long id, @RequestBody Faktura faktura) throws FakturaNotFoundException {
        fakturaService.update(id, faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeFaktura(@PathVariable Long id) throws FakturaNotFoundException {
        fakturaService.delete(fakturaService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}