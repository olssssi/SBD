package com.example.demo.towar;

import com.example.demo.pozycja.Pozycja;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import com.example.demo.zamowienie.ZamowienieService;
import org.springframework.stereotype.Service;

@Service
public class TowarAmountFacade {
    private final ZamowienieService zamowienieService;
    private final TowarService towarService;

    public TowarAmountFacade(ZamowienieService zamowienieService,
                             TowarService towarService){
        this.zamowienieService = zamowienieService;
        this.towarService = towarService;
    }

    public void finalizeZamowienie(Long id) throws ZamowienieNotFoundException, TowarNotFoundException {
        Zamowienie zamowienie = zamowienieService.findById(id);
        for (Pozycja pozycja:zamowienie.collectPozycje()) {
            decreaseTowarAmount(pozycja.getTowar(), pozycja.getIlosc());
        }
    }

    public void delivery(Long idTowaru, int amount) throws TowarNotFoundException {
        Towar towar = towarService.findById(idTowaru);
        increaseTowarAmount(towar, amount);
    }

    private void increaseTowarAmount(Towar towar, int amount) throws TowarNotFoundException {
        towar.setIlosc(towar.getIlosc()+amount);
        towarService.update(towar.getIdTowaru(), towar);
    }

    private void decreaseTowarAmount(Towar towar, int amount) throws TowarNotFoundException {
        towar.setIlosc(towar.getIlosc()-amount);
        towarService.update(towar.getIdTowaru(), towar);
    }

}
