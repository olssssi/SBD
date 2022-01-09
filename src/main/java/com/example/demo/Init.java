package com.example.demo;

import com.example.demo.faktura.Faktura;
import com.example.demo.faktura.FakturaRepository;
import com.example.demo.kategoria.Kategoria;
import com.example.demo.kategoria.KategoriaRepository;
import com.example.demo.klient.Klient;
import com.example.demo.klient.KlientRepository;
import com.example.demo.klient.KlientService;
import com.example.demo.pozycja.Pozycja;
import com.example.demo.pozycja.PozycjaRepository;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikRepository;
import com.example.demo.producent.Producent;
import com.example.demo.producent.ProducentRepository;
import com.example.demo.rabat.Rabat;
import com.example.demo.stanZamowienia.StanZamowienia;
import com.example.demo.stanowisko.Stanowisko;
import com.example.demo.stanowisko.StanowiskoRepository;
import com.example.demo.towar.Towar;
import com.example.demo.towar.TowarRepository;
import com.example.demo.rabat.RabatRepository;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final PracownikRepository pracownikRepository;
    private final StanowiskoRepository stanowiskoRepository;
    private final KategoriaRepository kategoriaRepository;
    private final TowarRepository towarRepository;
    private final ProducentRepository producentRepository;
    private final KlientRepository klientRepository;
    private final KlientService klientService;
    private final RabatRepository rabatRepository;
    private final ZamowienieRepository zamowienieRepository;
    private final PozycjaRepository pozycjaRepository;
    private final FakturaRepository fakturaRepository;

    @Autowired
    public Init(PracownikRepository pracownikRepository,
                StanowiskoRepository stanowiskoRepository,
                KategoriaRepository kategoriaRepository,
                TowarRepository towarRepository,
                ProducentRepository producentRepository,
                KlientRepository klientRepository,
                KlientService klientService,
                RabatRepository rabatRepository,
                ZamowienieRepository zamowienieRepository,
                PozycjaRepository pozycjaRepository,
                FakturaRepository fakturaRepository) {
        this.pracownikRepository = pracownikRepository;
        this.stanowiskoRepository = stanowiskoRepository;
        this.kategoriaRepository = kategoriaRepository;
        this.towarRepository = towarRepository;
        this.producentRepository = producentRepository;
        this.klientRepository = klientRepository;
        this.klientService = klientService;
        this.rabatRepository = rabatRepository;
        this.zamowienieRepository = zamowienieRepository;
        this.pozycjaRepository = pozycjaRepository;
        this.fakturaRepository = fakturaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        pozycjaRepository.deleteAll();
        zamowienieRepository.deleteAll();
        fakturaRepository.deleteAll();
        pracownikRepository.deleteAll();
        stanowiskoRepository.deleteAll();
        towarRepository.deleteAll();
        kategoriaRepository.deleteAll();
        producentRepository.deleteAll();
        klientRepository.deleteAll();
        rabatRepository.deleteAll();

        Producent producent = new Producent("BEKO");
        Stanowisko stanowisko = new Stanowisko("Magazynier");
        Pracownik pracownik = new Pracownik("Anna", "Kowalska", "502365254", stanowisko);

        Rabat rabat1 = new Rabat("Stały klient", 10F);
        Rabat rabat2 = new Rabat("Premium klient", 15F);
        Rabat rabat3 = new Rabat("Polecający klient", 5F);
        Rabat rabat4 = new Rabat("Brak rabatu", 0F);

        Kategoria kategoria1 = new Kategoria("Lodówki", 23F);
        Kategoria kategoria2 = new Kategoria("Pralki", 23F);
        Kategoria kategoria3 = new Kategoria("Suszarki", 23F);
        Kategoria kategoria4 = new Kategoria("Kuchenki", 23F);
        Kategoria kategoria5 = new Kategoria("Zmywarki", 23F);
        Kategoria kategoria6 = new Kategoria("Okapy", 23F);
        Kategoria kategoria7 = new Kategoria("Piekarniki", 23F);

        Towar towar1 = new Towar("Lodówka BEKO RCSK300K30XBRN 181cm Ciemny Inox", producent, kategoria1, 1000F, 500);
        Towar towar2 = new Towar("Lodówka BEKO XCSK3052XBKNWS 181cm Jasny Inox", producent, kategoria1, 1500F, 1000);

        Klient klient = new Klient(
                "Agnieszka",
                "Wisniewska",
                "602987250",
                "a.wisniewska@mail.com",
                "WISNIEWSKA S.Z.O.O",
                "6761059375",
                "Wiejska",
                "5/2",
                "Białystok",
                "15-058",
                "Polska"
        );

        Faktura faktura = new Faktura();
        Zamowienie zamowienie1 = new Zamowienie(klient, pracownik);
        Zamowienie zamowienie2 = new Zamowienie(klient, pracownik);
        Pozycja pozycja1 = new Pozycja(2, towar1);
        Pozycja pozycja2 = new Pozycja( 10, towar1);
        Pozycja pozycja3 = new Pozycja(2, towar2);

        Zamowienie zamowienie3 = new Zamowienie(klient, pracownik);

        pozycja1.setZamowienie(zamowienie1);
        pozycja2.setZamowienie(zamowienie3);
        pozycja3.setZamowienie(zamowienie2);

        zamowienie1.setFaktura(faktura);
        zamowienie2.setFaktura(faktura);
        zamowienie2.setStanZamowienia(StanZamowienia.W_REALIZACJI);


//        Zamowienie zamowienie1 = new Zamowienie(klient, pracownik, Set.of(pozycja1, pozycja2));
//        Zamowienie zamowienie2 = new Zamowienie(klient, pracownik, Set.of(pozycja3));
//        zamowienie1.setFaktura(faktura);


        producentRepository.save(producent);
        stanowiskoRepository.save(stanowisko);
        pracownikRepository.save(pracownik);
        kategoriaRepository.save(kategoria1);
        kategoriaRepository.save(kategoria2);
        kategoriaRepository.save(kategoria3);
        kategoriaRepository.save(kategoria4);
        kategoriaRepository.save(kategoria5);
        kategoriaRepository.save(kategoria6);
        kategoriaRepository.save(kategoria7);
        rabatRepository.save(rabat1);
        rabatRepository.save(rabat2);
        rabatRepository.save(rabat3);
        rabatRepository.save(rabat4);
        towarRepository.save(towar1);
        towarRepository.save(towar2);
        klientService.save(klient);
        fakturaRepository.save(faktura);
        zamowienieRepository.save(zamowienie1);
        pozycjaRepository.save(pozycja1);
        zamowienieRepository.save(zamowienie2);
        zamowienieRepository.save(zamowienie3);
        pozycjaRepository.save(pozycja2);
        pozycjaRepository.save(pozycja3);
    }
}
