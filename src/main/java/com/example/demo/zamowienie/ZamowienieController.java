package com.example.demo.zamowienie;

import com.example.demo.exceptions.KlientNotFoundException;
import com.example.demo.exceptions.PracownikNotFoundException;
import com.example.demo.exceptions.ZamowienieNotFoundException;
import com.example.demo.klient.Klient;
import com.example.demo.klient.KlientService;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/zamowienia")
public class ZamowienieController {
    private final ZamowienieService zamowienieService;
    private final PracownikService pracownikService;
    private final KlientService klientService;

    @Autowired
    public ZamowienieController(ZamowienieService zamowienieService,
                                PracownikService pracownikService,
                                KlientService klientService) {
        this.zamowienieService = zamowienieService;
        this.pracownikService = pracownikService;
        this.klientService = klientService;
    }

    @GetMapping("")
    public ResponseEntity<List<Zamowienie>> getZamowienia() {
        return new ResponseEntity<>(zamowienieService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/klient/{id}")
    public ResponseEntity<List<Zamowienie>> getZamowieniaByKlient(@PathVariable Long id) throws KlientNotFoundException {
        Klient klient = klientService.findById(id);
        return new ResponseEntity<>(zamowienieService.findByKlient(klient), HttpStatus.OK);
    }

    @GetMapping("/pracownik/{id}")
    public ResponseEntity<List<Zamowienie>> getZamowieniaByPracownik(@PathVariable Long id) throws PracownikNotFoundException {
        Pracownik pracownik = pracownikService.findById(id);
        return new ResponseEntity<>(zamowienieService.findByPracownik(pracownik), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zamowienie> getZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        return new ResponseEntity<>(zamowienieService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addZamowienie(@RequestBody Zamowienie zamowienie) {
        zamowienieService.save(zamowienie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateZamowienie(@PathVariable Long id, @RequestBody Zamowienie zamowienie) throws ZamowienieNotFoundException {
        zamowienieService.update(id, zamowienie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        zamowienieService.delete(zamowienieService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
