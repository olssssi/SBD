package com.example.demo.towar;

import com.example.demo.exceptions.TowarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towary")
public class TowarController {
    private final TowarService towarService;
    @Autowired
    public TowarController(TowarService towarService) {
        this.towarService = towarService;
    }

    @GetMapping("")
    public ResponseEntity<List<Towar>> getTowary() {
        return new ResponseEntity<>(towarService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Towar> getTowar(@PathVariable Long id) throws TowarNotFoundException {
        return new ResponseEntity<>(towarService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<HttpStatus> addTowar(@RequestBody Towar Towar) {
        towarService.save(Towar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateTowar(@PathVariable Long id, @RequestBody Towar Towar) throws TowarNotFoundException {
        towarService.update(id, Towar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeTowar(@PathVariable Long id) throws TowarNotFoundException {
        towarService.delete(towarService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
