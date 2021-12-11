package com.example.demo.zamowienie;

import com.example.demo.exceptions.ZamowienieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zamowienia")
public class ZamowienieController {
    private final ZamowienieService zamowienieService;
    @Autowired
    public ZamowienieController(ZamowienieService zamowienieService) {
        this.zamowienieService = zamowienieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Zamowienie>> getZamowienia() {
        return new ResponseEntity<>(zamowienieService.findAll(), HttpStatus.OK);
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
