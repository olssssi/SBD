package com.example.demo.rabat;

import com.example.demo.exceptions.RabatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/rabaty")
public class RabatController {
    private final RabatService rabatService;

    @Autowired
    public RabatController(RabatService rabatService) {
        this.rabatService = rabatService;
    }

    @GetMapping("")
    public ResponseEntity<List<Rabat>> getRabaty() {
        return new ResponseEntity<>(rabatService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rabat> getRabat(@PathVariable Long id) throws RabatNotFoundException {
        return new ResponseEntity<>(rabatService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addRabat(@RequestBody Rabat rabat) {
        rabatService.save(rabat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateRabat(@PathVariable Long id,
                                                  @RequestBody Rabat rabat) throws RabatNotFoundException {
        rabatService.update(id, rabat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeRabat(@PathVariable Long id) throws RabatNotFoundException {
        rabatService.delete(rabatService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}