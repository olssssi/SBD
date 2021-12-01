package com.example.demo.klient;

import com.example.demo.exceptions.KlientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Klient> getClass(@PathVariable Long id) throws KlientNotFoundException {
        return new ResponseEntity<>(klientService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addGroup(@RequestBody Klient group) {
        klientService.save(group);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateGroup(@PathVariable Long id, @RequestBody Klient group) throws KlientNotFoundException {
        klientService.update(id, group);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeGroup(@PathVariable Long id) throws KlientNotFoundException {
        klientService.delete(klientService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
