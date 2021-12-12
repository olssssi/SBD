package com.example.demo;

import com.example.demo.cena.Cena;
import com.example.demo.cena.CenaRepository;
import com.example.demo.kategoria.Kategoria;
import com.example.demo.kategoria.KategoriaRepository;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.pracownik.PracownikRepository;
import com.example.demo.producent.Producent;
import com.example.demo.producent.ProducentRepository;
import com.example.demo.stanowisko.Stanowisko;
import com.example.demo.stanowisko.StanowiskoRepository;
import com.example.demo.towar.Towar;
import com.example.demo.towar.TowarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final PracownikRepository pracownikRepository;
    private final StanowiskoRepository stanowiskoRepository;
    private final KategoriaRepository kategoriaRepository;
    private final TowarRepository towarRepository;
    private final CenaRepository cenaRepository;
    private final ProducentRepository producentRepository;

    @Autowired
    public Init(PracownikRepository pracownikRepository,
                StanowiskoRepository stanowiskoRepository,
                KategoriaRepository kategoriaRepository,
                TowarRepository towarRepository,
                CenaRepository cenaRepository,
                ProducentRepository producentRepository) {
        this.pracownikRepository = pracownikRepository;
        this.stanowiskoRepository = stanowiskoRepository;
        this.kategoriaRepository = kategoriaRepository;
        this.towarRepository = towarRepository;
        this.cenaRepository = cenaRepository;
        this.producentRepository = producentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        pracownikRepository.deleteAll();
        stanowiskoRepository.deleteAll();
        kategoriaRepository.deleteAll();
        towarRepository.deleteAll();
        cenaRepository.deleteAll();
        producentRepository.deleteAll();

        Producent producent = new Producent("BEKO");
        Stanowisko stanowisko = new Stanowisko("Magazynier");
        Pracownik pracownik = new Pracownik("Anna", "Kowalska", "502365254", stanowisko);

        Kategoria kategoria1 = new Kategoria("Lodówki");
        Kategoria kategoria2 = new Kategoria("Pralki");
        Kategoria kategoria3 = new Kategoria("Suszarki");
        Kategoria kategoria4 = new Kategoria("Kuchenki");
        Kategoria kategoria5 = new Kategoria("Zmywarki");
        Kategoria kategoria6 = new Kategoria("Okapy");
        Kategoria kategoria7 = new Kategoria("Piekarniki");


        Towar towar = new Towar(producent, kategoria1, 500);
        Cena cena = new Cena(999F,23F,towar);
        towar.setCena(cena);


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

        towarRepository.save(towar);
        cenaRepository.save(cena);
    }
}
