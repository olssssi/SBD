package com.example.demo;

import com.example.demo.kategoria.Kategoria;
import com.example.demo.kategoria.KategoriaRepository;
import com.example.demo.klient.Klient;
import com.example.demo.klient.KlientRepository;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikRepository;
import com.example.demo.producent.Producent;
import com.example.demo.producent.ProducentRepository;
import com.example.demo.rabat.Rabat;
import com.example.demo.stanowisko.Stanowisko;
import com.example.demo.stanowisko.StanowiskoRepository;
import com.example.demo.towar.Towar;
import com.example.demo.towar.TowarRepository;
import com.example.demo.rabat.RabatRepository;
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
    private final RabatRepository rabatRepository;

    @Autowired
    public Init(PracownikRepository pracownikRepository,
                StanowiskoRepository stanowiskoRepository,
                KategoriaRepository kategoriaRepository,
                TowarRepository towarRepository,
                ProducentRepository producentRepository,
                KlientRepository klientRepository,
                RabatRepository rabatRepository) {
        this.pracownikRepository = pracownikRepository;
        this.stanowiskoRepository = stanowiskoRepository;
        this.kategoriaRepository = kategoriaRepository;
        this.towarRepository = towarRepository;
        this.producentRepository = producentRepository;
        this.klientRepository = klientRepository;
        this.rabatRepository = rabatRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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

        Kategoria kategoria1 = new Kategoria("Lodówki", 23F);
        Kategoria kategoria2 = new Kategoria("Pralki", 23F);
        Kategoria kategoria3 = new Kategoria("Suszarki", 23F);
        Kategoria kategoria4 = new Kategoria("Kuchenki", 23F);
        Kategoria kategoria5 = new Kategoria("Zmywarki", 23F);
        Kategoria kategoria6 = new Kategoria("Okapy", 23F);
        Kategoria kategoria7 = new Kategoria("Piekarniki", 23F);

        Towar towar = new Towar(producent, kategoria1, 1000F, 500);

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
                "Polska",
                rabat3
        );

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
        towarRepository.save(towar);
        klientRepository.save(klient);
    }
}
