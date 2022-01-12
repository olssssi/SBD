package com.example.demo.zamowienie;

import com.example.demo.faktura.FakturaService;
import com.example.demo.klient.KlientNotFoundException;
import com.example.demo.pracownik.PracownikNotFoundException;
import com.example.demo.faktura.Faktura;
import com.example.demo.klient.Klient;
import com.example.demo.klient.KlientService;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikService;
import com.example.demo.stanZamowienia.StanZamowienia;
import com.example.demo.towar.TowarAmountFacade;
import com.example.demo.towar.TowarNotFoundException;
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
    private final FakturaService fakturaService;
    private final TowarAmountFacade towarAmountFacade;

    @Autowired
    public ZamowienieController(ZamowienieService zamowienieService,
                                PracownikService pracownikService,
                                KlientService klientService,
                                FakturaService fakturaService,
                                TowarAmountFacade towarAmountFacade) {
        this.zamowienieService = zamowienieService;
        this.pracownikService = pracownikService;
        this.klientService = klientService;
        this.fakturaService = fakturaService;
        this.towarAmountFacade = towarAmountFacade;
    }

    @GetMapping("")
    public ResponseEntity<List<Zamowienie>> getZamowienia() {
        zamowienieService.calcSum();
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
    public ResponseEntity<Zamowienie> addZamowienie(@RequestBody Zamowienie zamowienie) {
        return new ResponseEntity<>(zamowienieService.save(zamowienie), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateZamowienie(@PathVariable Long id, @RequestBody Zamowienie zamowienie) throws ZamowienieNotFoundException {
        zamowienieService.update(id, zamowienie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/faktura/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> assignFakturaToZamowienie(@PathVariable Long id, @RequestBody Faktura faktura) throws ZamowienieNotFoundException {
        zamowienieService.assignFaktura(id, faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/w-realizacji/{id}")
    public ResponseEntity<HttpStatus> inRealizationZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        Zamowienie zamowienie = zamowienieService.findById(id);
        zamowienie.setStanZamowienia(StanZamowienia.W_REALIZACJI);
        zamowienieService.save(zamowienie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/do-zaplaty/{id}")
    public ResponseEntity<HttpStatus> toPayZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        Zamowienie zamowienie = zamowienieService.findById(id);
        zamowienie.setStanZamowienia(StanZamowienia.DO_OPLATY);
        fakturaService.checkRealization(zamowienie.getFaktura());
        zamowienieService.save(zamowienie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/realizuj/{id}")
    public ResponseEntity<HttpStatus> finalizeZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException, TowarNotFoundException {
        towarAmountFacade.finalizeZamowienie(id);
        zamowienieService.delete(zamowienieService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeZamowienie(@PathVariable Long id) throws ZamowienieNotFoundException {
        zamowienieService.delete(zamowienieService.findById(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
