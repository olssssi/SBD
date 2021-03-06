package com.example.demo.towar;

import com.example.demo.kategoria.KategoriaNotFoundException;
import com.example.demo.producent.ProducentNotFoundException;
import com.example.demo.kategoria.Kategoria;
import com.example.demo.kategoria.KategoriaService;
import com.example.demo.producent.Producent;
import com.example.demo.producent.ProducentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/towary")
public class TowarController {
    private final TowarService towarService;
    private final ProducentService producentService;
    private final KategoriaService kategoriaService;
    private final TowarAmountFacade towarAmountFacade;

    @Autowired
    public TowarController(TowarService towarService,
                           ProducentService producentService,
                           KategoriaService kategoriaService,
                           TowarAmountFacade towarAmountFacade) {
        this.towarService = towarService;
        this.producentService = producentService;
        this.kategoriaService = kategoriaService;
        this.towarAmountFacade = towarAmountFacade;
    }

    @GetMapping("")
    public ResponseEntity<List<Towar>> getTowary() {
        return new ResponseEntity<>(towarService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/producent/{id}")
    public ResponseEntity<List<Towar>> getTowaryByProducent(@PathVariable Long id) throws ProducentNotFoundException {
        Producent producent = producentService.findById(id);
        return new ResponseEntity<>(towarService.findByProducent(producent), HttpStatus.OK);
    }

    @GetMapping("/kategoria/{id}")
    public ResponseEntity<List<Towar>> getTowaryByKategoria(@PathVariable Long id) throws KategoriaNotFoundException {
        Kategoria kategoria = kategoriaService.findById(id);
        return new ResponseEntity<>(towarService.findByKategoria(kategoria), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Towar> getTowar(@PathVariable Long id) throws TowarNotFoundException {
        return new ResponseEntity<>(towarService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addTowar(@RequestBody Towar towar) {
        towarService.save(towar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateTowar(@PathVariable Long id, @RequestBody Towar towar) throws TowarNotFoundException {
        towarService.update(id, towar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/dostawa/{id}/{amount}")
    @ResponseBody
    public ResponseEntity<HttpStatus> delivery(@PathVariable Long id, @PathVariable int amount) throws TowarNotFoundException {
        towarAmountFacade.delivery(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeTowar(@PathVariable Long id) throws TowarNotFoundException {
        towarService.delete(towarService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
