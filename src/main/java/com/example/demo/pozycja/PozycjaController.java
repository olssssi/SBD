package com.example.demo.pozycja;

import com.example.demo.exceptions.PozycjaNotFoundException;
import com.example.demo.exceptions.ZamowienieNotFoundException;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/pozycje")
public class PozycjaController {
    private final PozycjaService pozycjaService;
    private final ZamowienieService zamowienieService;

    @Autowired
    public PozycjaController(PozycjaService pozycjaService,
                             ZamowienieService zamowienieService) {
        this.pozycjaService = pozycjaService;
        this.zamowienieService = zamowienieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Pozycja>> getPozycje() {
        return new ResponseEntity<>(pozycjaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/zamowienie/{id}")
    public ResponseEntity<List<Pozycja>> getPozycjeByZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        Zamowienie zamowienie = zamowienieService.findById(id);
        return new ResponseEntity<>(pozycjaService.findByZamowienie(zamowienie), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pozycja> getPozycja(@PathVariable Long id) throws PozycjaNotFoundException {
        return new ResponseEntity<>(pozycjaService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addPozycja(@RequestBody Pozycja pozycja) {
        pozycjaService.save(pozycja);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updatePozycja(@PathVariable Long id, @RequestBody Pozycja pozycja) throws PozycjaNotFoundException {
        pozycjaService.update(id, pozycja);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removePracownik(@PathVariable Long id) throws PozycjaNotFoundException {
        pozycjaService.delete(pozycjaService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
