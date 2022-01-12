package com.example.demo.faktura;

import com.example.demo.stanZamowienia.StanZamowienia;
import com.example.demo.towar.TowarAmountFacade;
import com.example.demo.towar.TowarNotFoundException;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import com.example.demo.zamowienie.ZamowienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Service
public class FakturaService {
    private final FakturaRepository fakturaRepository;
    private final ZamowienieRepository zamowienieRepository;
    private final TowarAmountFacade towarAmountFacade;

    @Autowired
    public FakturaService(FakturaRepository fakturaRepository,
                          ZamowienieRepository zamowienieRepository,
                          TowarAmountFacade towarAmountFacade) {
        this.fakturaRepository = fakturaRepository;
        this.zamowienieRepository = zamowienieRepository;
        this.towarAmountFacade = towarAmountFacade;
    }

    public Faktura findById(Long id) throws FakturaNotFoundException {
        return fakturaRepository.findById(id)
                .orElseThrow(FakturaNotFoundException::new);
    }

    public Set<Zamowienie> getZamowienia(Faktura faktura){
        return faktura.collectZamowienia();
    }

    public void registerAsPaid(Faktura faktura) throws ZamowienieNotFoundException, TowarNotFoundException {
        for (Zamowienie zamowienie:faktura.collectZamowienia()) {
            zamowienie.setStanZamowienia(StanZamowienia.OPLACONE);
            towarAmountFacade.finalizeZamowienie(zamowienie.getIdZamowienia());
            zamowienieRepository.save(zamowienie);
        }
        faktura.setDataRealizacji(OffsetDateTime.now());
        fakturaRepository.save(faktura);
    }

    public void checkRealization(Faktura faktura){
        for (Zamowienie z: getZamowienia(faktura)) {
            if(z.getStanZamowienia()!= StanZamowienia.DO_OPLATY){
                return;
            }
        }
        faktura.setCzyWszystkieZamowieniaZrealizowane(true);
        fakturaRepository.save(faktura);
    }

    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }

    public Faktura save(Faktura cena) {
        return fakturaRepository.save(cena);
    }

    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

    public void calcSum(){
        for (Faktura faktura: fakturaRepository.findAll()) {
            float brutto = 0;
            float netto = 0;
            for (Zamowienie zamowienie: getZamowienia(faktura)) {
                brutto = brutto + zamowienie.getKwotaBrutto();
                netto = netto + zamowienie.getKwotaNetto();
            }
            faktura.setKwotaBrutto(brutto);
            faktura.setKwotaNetto(netto);
        }
    }

}