package com.example.demo.cena;

import com.example.demo.exceptions.CenaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ceny")
public class CenaController {
    private final CenaService cenaService;

    @Autowired
    public CenaController(CenaService cenaService) {
        this.cenaService = cenaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cena>> getCeny() {
        return new ResponseEntity<>(cenaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cena> getCena(@PathVariable Long id) throws CenaNotFoundException {
        return new ResponseEntity<>(cenaService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addCena(@RequestBody Cena cena) {
        cenaService.save(cena);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateCena(@PathVariable Long id, @RequestBody Cena cena) throws CenaNotFoundException {
        cenaService.update(id, cena);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeCena(@PathVariable Long id) throws CenaNotFoundException {
        cenaService.delete(cenaService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
