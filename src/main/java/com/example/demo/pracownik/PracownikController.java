package com.example.demo.pracownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/pracownicy")
public class PracownikController {
    private final PracownikService pracownikService;

    @Autowired
    public PracownikController(PracownikService pracownikService) {
        this.pracownikService = pracownikService;
    }

    @GetMapping("")
    public ResponseEntity<List<Pracownik>> getPracownicy() {
        return new ResponseEntity<>(pracownikService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pracownik> getPracownik(@PathVariable Long id) throws PracownikNotFoundException {
        return new ResponseEntity<>(pracownikService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addPracownik(@RequestBody Pracownik pracownik) {
        pracownikService.save(pracownik);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updatePracownik(@PathVariable Long id, @RequestBody Pracownik pracownik) throws PracownikNotFoundException {
        pracownikService.update(id, pracownik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removePracownik(@PathVariable Long id) throws PracownikNotFoundException {
        pracownikService.delete(pracownikService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
