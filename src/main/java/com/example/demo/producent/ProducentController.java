package com.example.demo.producent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/producenci")
public class ProducentController {
    private final ProducentService producentService;

    @Autowired
    public ProducentController(ProducentService producentService) {
        this.producentService = producentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Producent>> getProducenci() {
        return new ResponseEntity<>(producentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producent> getProducent(@PathVariable Long id) throws ProducentNotFoundException {
        return new ResponseEntity<>(producentService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addProducent(@RequestBody Producent producent) {
        producentService.save(producent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateProducent(@PathVariable Long id, @RequestBody Producent producent) throws ProducentNotFoundException {
        producentService.update(id, producent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeProducent(@PathVariable Long id) throws ProducentNotFoundException {
        producentService.delete(producentService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
