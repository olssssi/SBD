package com.example.demo.klient;

import com.example.demo.rabat.Rabat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/klienci")
public class KlientController {
    private final KlientService klientService;
    @Autowired
    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping("")
    public ResponseEntity<List<Klient>> getKlienci() {
        return new ResponseEntity<>(klientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klient> getKlient(@PathVariable Long id) throws KlientNotFoundException {
        return new ResponseEntity<>(klientService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addKlient(@RequestBody Klient klient) {
        klientService.save(klient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateKlient(@PathVariable Long id, @RequestBody Klient klient) throws KlientNotFoundException {
        klientService.update(id, klient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/rabat/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> grantDiscount(@PathVariable Long id, @RequestBody Rabat rabat) throws KlientNotFoundException {
        klientService.grantDiscount(id, rabat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeGroup(@PathVariable Long id) throws KlientNotFoundException {
        klientService.delete(klientService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
