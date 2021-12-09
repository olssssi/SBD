package com.example.demo.kategoria;

import com.example.demo.exceptions.KategoriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faktury")
public class KategoriaController {
    private final KategoriaService kategoriaService;

    @Autowired
    public KategoriaController(KategoriaService kategoriaService) {
        this.kategoriaService = kategoriaService;
    }

    @GetMapping("")
    public ResponseEntity<List<Kategoria>> getKategorie() {
        return new ResponseEntity<>(kategoriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kategoria> getKategoria(@PathVariable Long id) throws KategoriaNotFoundException {
        return new ResponseEntity<>(kategoriaService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addKategoria(@RequestBody Kategoria kategoria) {
        kategoriaService.save(kategoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateKategoria(@PathVariable Long id, @RequestBody Kategoria kategoria) throws KategoriaNotFoundException {
        kategoriaService.update(id, kategoria);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeKategoria(@PathVariable Long id) throws KategoriaNotFoundException {
        kategoriaService.delete(kategoriaService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}