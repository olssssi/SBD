package com.example.demo.stanowisko;

import com.example.demo.exceptions.StanowiskoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/stanowiska")
public class StanowiskoController {
    private final StanowiskoService stanowiskoService;

    @Autowired
    public StanowiskoController(StanowiskoService stanowiskoService) {
        this.stanowiskoService = stanowiskoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Stanowisko>> getStanowiskoPracownicy() {
        return new ResponseEntity<>(stanowiskoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stanowisko> getStanowisko(@PathVariable Long id) throws StanowiskoNotFoundException {
        return new ResponseEntity<>(stanowiskoService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addStanowisko(@RequestBody Stanowisko stanowisko) {
        stanowiskoService.save(stanowisko);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateStanowisko(@PathVariable Long id, @RequestBody Stanowisko stanowisko) throws StanowiskoNotFoundException {
        stanowiskoService.update(id, stanowisko);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeStanowisko(@PathVariable Long id) throws StanowiskoNotFoundException {
        stanowiskoService.delete(stanowiskoService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
