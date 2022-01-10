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

        Producent producent1 = new Producent("BEKO");
        Producent producent2 = new Producent("BOSCH");
        Producent producent3 = new Producent("ELECTROLUX");
        Producent producent4 = new Producent("WHIRLPOOL");
        Producent producent5 = new Producent("SIEMENS");
        Producent producent6 = new Producent("AMICA");
        Producent producent7 = new Producent("SAMSUNG");

        Stanowisko stanowisko1 = new Stanowisko("Młodszy magazynier");
        Stanowisko stanowisko2 = new Stanowisko("Magazynier");
        Stanowisko stanowisko3 = new Stanowisko("Starszy magazynier");

        Pracownik pracownik1 = new Pracownik("Anna", "Kowalska", "502365254", stanowisko3);
        Pracownik pracownik2 = new Pracownik("Leon", "Borowski", "510369875", stanowisko2);
        Pracownik pracownik3 = new Pracownik("Krzysztof", "Nowak", "702369850", stanowisko2);
        Pracownik pracownik4 = new Pracownik("Piotr", "Lato", "881251023", stanowisko1);
        Pracownik pracownik5 = new Pracownik("Katarzyna", "Wiśniewska", "632012013", stanowisko2);
        Pracownik pracownik6 = new Pracownik("Sebastian", "Komar", "518403698", stanowisko1);
        Pracownik pracownik7 = new Pracownik("Paulina", "Piotrowska", "518402512", stanowisko2);
        Pracownik pracownik8 = new Pracownik("Oliwia", "Sokołowska", "602698771", stanowisko2);
        Pracownik pracownik9 = new Pracownik("Radosław", "Laskowski", "530102602", stanowisko2);
        Pracownik pracownik10 = new Pracownik("Zygmunt", "Polak", "602302698", stanowisko3);

        Rabat rabat1 = new Rabat("Stały klient", 10F);
        Rabat rabat2 = new Rabat("Premium klient", 15F);
        Rabat rabat3 = new Rabat("Polecający klient", 5F);
        Rabat rabat4 = new Rabat("Brak rabatu", 0F);

        Kategoria kategoria1 = new Kategoria("Lodówki", 23F);
        Kategoria kategoria2 = new Kategoria("Zamrażarki", 23F);
        Kategoria kategoria3 = new Kategoria("Okapy", 23F);
        Kategoria kategoria4 = new Kategoria("Kuchenki", 23F);
        Kategoria kategoria5 = new Kategoria("Zmywarki", 23F);
        Kategoria kategoria6 = new Kategoria("Płyty indukcyjne", 23F);
        Kategoria kategoria7 = new Kategoria("Pralki", 23F);
        Kategoria kategoria8 = new Kategoria("Suszarki", 23F);

        Towar towar1 = new Towar("Lodówka BEKO RCSK300K30XBRN 181cm Ciemny Inox", producent1, kategoria1, 1599F, 1000);
        Towar towar2 = new Towar("Lodówka Whirlpool W7 921O K AQUA", producent4, kategoria1, 1499F, 1000);
        Towar towar3 = new Towar("Zmywarka Whirlpool WFO 3T141 X", producent4, kategoria5, 1699F, 1000);
        Towar towar4 = new Towar("Zmywarka BEKO DFN16420X", producent1, kategoria5, 1999F, 1000);
        Towar towar5 = new Towar("Zmywarka Beko DFS26024X", producent1, kategoria5, 2599F, 1000);
        Towar towar6 = new Towar("Lodówka Samsung RB29FERNCSS", producent7, kategoria1, 2599F, 1000);
        Towar towar7 = new Towar("Lodówka Samsung Bespoke RB38A7B5E22 ", producent7, kategoria1, 2999F, 1000);
        Towar towar8 = new Towar("Lodówka Samsung RB29FWJNDBC", producent7, kategoria1, 1679F, 1000);
        Towar towar9 = new Towar("Zamrażarka Amica FZ206.4", producent6, kategoria2, 599F, 1000);
        Towar towar10 = new Towar("Zamrażarka MPM 80-ZS-06x", producent2, kategoria2, 1199F, 1000);
        Towar towar11 = new Towar("Zamrażarka MPM 80-ZS-06", producent2, kategoria2, 1099F, 1000);
        Towar towar12 = new Towar("Zamrażarka Candy CCHM 200/N", producent2, kategoria2, 899F, 1000);
        Towar towar13 = new Towar("Okap Whirlpool AKR 749/1 NB", producent4, kategoria3, 499F, 1000);
        Towar towar14 = new Towar("Okap Amica OKC6242S", producent6, kategoria3, 899F, 1000);
        Towar towar15 = new Towar("Okap Electrolux LFT769X", producent3, kategoria3, 599F, 1000);
        Towar towar16 = new Towar("Okap Amica OKP6655S", producent6, kategoria3, 1299F, 1000);
        Towar towar17 = new Towar("Okap Samsung NK24M5070FS", producent7, kategoria3, 1599F, 1000);
        Towar towar18 = new Towar("Okap Amica OMP6253BG", producent6, kategoria3, 1389F, 1000);
        Towar towar19 = new Towar("Płyta indukcyjna Whirlpool WL S3160 BF", producent4, kategoria6, 999F, 1000);
        Towar towar20 = new Towar("Płyta indukcyjna Electrolux Slim-fit CIV654", producent3, kategoria6, 1000F, 1000);
        Towar towar21 = new Towar("Płyta indukcyjna Whirlpool WL S7960 NE", producent4, kategoria6, 1699F, 1000);
        Towar towar22 = new Towar("Płyta indukcyjna Bosch PPP6A6B90", producent2, kategoria6, 1499F, 1000);
        Towar towar23 = new Towar("Płyta indukcyjna Electrolux Slim-fit CIV634", producent3, kategoria6, 1500F, 1000);
        Towar towar24 = new Towar("Kuchenka Beko FSE52322DWD", producent1, kategoria4, 1500F, 1000);
        Towar towar25 = new Towar("Kuchenka Amica 58GGD1.23OFP(Xv)", producent6, kategoria4, 2500F, 1000);
        Towar towar26 = new Towar("Kuchenka Amica 510GEM2.33ZpTa(W)", producent6, kategoria4, 1999F, 1000);
        Towar towar27 = new Towar("Kuchenka Beko FSE52321DBD", producent1, kategoria4, 999F, 1000);
        Towar towar28 = new Towar("Kuchenka Beko FSM57300GX", producent1, kategoria4, 1329F, 1000);
        Towar towar29 = new Towar("Zmywarka Whirlpool WFO 3T141 X", producent4, kategoria5, 1099F, 1000);
        Towar towar30 = new Towar("Zmywarka Beko DFN16420X", producent1, kategoria5, 1199F, 1000);
        Towar towar31 = new Towar("Zmywarka Beko DFS26024X", producent1, kategoria5, 1000F, 1000);
        Towar towar32 = new Towar("Zmywarka Beko DFS05024W", producent1, kategoria5, 1899F, 1000);
        Towar towar33 = new Towar("Zmywarka Amica DFM41E6qWEU", producent6, kategoria5, 1999F, 1000);
        Towar towar34 = new Towar("Zmywarka Samsung DW60A6092FS", producent7, kategoria5, 1700F, 1000);
        Towar towar35 = new Towar("Pralka Whirlpool W6 W845WB PL Supreme Silence", producent4, kategoria7, 1400F, 1000);
        Towar towar36 = new Towar("Pralka Samsung WW90T654DLH AddWash AI Control", producent7, kategoria7, 1599F, 1000);
        Towar towar37 = new Towar("Pralka Whirlpool ETDLR 65332BS PL/N", producent4, kategoria7, 2000F, 1000);
        Towar towar38 = new Towar("Pralka Siemens WM14N29XPL iQ300 iSensoric", producent5, kategoria7, 1999F, 1000);
        Towar towar39 = new Towar("Pralka Whirlpool FWSL 61251 B PL N", producent4, kategoria7, 1350F, 1000);
        Towar towar40 = new Towar("Suszarka Whirlpool FFTE D 9X3B PL", producent4, kategoria8, 2999F, 1000);
        Towar towar41 = new Towar("Suszarka Bosch Serie 8 WTX87K40PL", producent2, kategoria8, 1550F, 1000);
        Towar towar42 = new Towar("Suszarka Electrolux EW9H188SPC PerfectCare", producent3, kategoria8, 1500F, 1000);
        Towar towar43 = new Towar("Suszarka Siemens WT47RTE0PL iQ500", producent5, kategoria8, 1899F, 1000);
        Towar towar44 = new Towar("Suszarka Siemens WT47XKH0PL iQ700", producent5, kategoria8, 2599F, 1000);
        Towar towar45 = new Towar("Suszarka Amica AD2C82KVD", producent6, kategoria8, 3200F, 1000);
        Towar towar46 = new Towar("Suszarka Siemens WT47XKH0PL iQ700", producent5, kategoria8, 3300F, 1000);
        Towar towar47 = new Towar("Zmywarka Siemens iQ300 SN23II08TE", producent5, kategoria5, 1699F, 1000);
        Towar towar48 = new Towar("Zmywarka Siemens iQ700 SN27YI01CE", producent5, kategoria5, 1799F, 1000);
        Towar towar49 = new Towar("Zmywarka Bosch SGS2ITW04E", producent2, kategoria5, 1399F, 1000);
        Towar towar50 = new Towar("Zmywarka Bosch SPS4EKI28E", producent2, kategoria5, 1250F, 1000);

        Klient klient1 = new Klient(
                "Paulina",
                "Szymborska",
                "602987250",
                "p.szymborska@mail.com",
                "SZYMBORSKA S.Z.O.O",
                "6761059375",
                "Wiejska",
                "5/2",
                "Białystok",
                "15-058",
                "Polska"
        );

        Klient klient2 = new Klient(
                "Karol",
                "Uścinak",
                "503698725",
                "k.uscinak@mail.com",
                "USCINAK",
                "7715059375",
                "Polna",
                "15",
                "Białystok",
                "15-057",
                "Polska"
        );

        Klient klient3 = new Klient(
                "Robert",
                "Pat",
                "881250396",
                "r.pat@mail.com",
                "Pat",
                "9961000375",
                "Szkolna",
                "102",
                "Białystok",
                "15-058",
                "Polska"
        );

        Klient klient4 = new Klient(
                "Patryk",
                "Kowalczyk",
                "702356982",
                "p.kowalczyk@mail.com",
                "Kowalczyk S.Z.O.O",
                "9961001375",
                "Boczna",
                "25/1",
                "Białystok",
                "15-057",
                "Polska"
        );

        Klient klient5 = new Klient(
                "Monika",
                "Nowa",
                "669352012",
                "m.nowa!mail.com",
                "Nowa Firma",
                "8761259255",
                "Rynek",
                "32A/2",
                "Białystok",
                "15-058",
                "Polska"
        );

        Klient klient6 = new Klient(
                "Olga",
                "Smak",
                "880215698",
                "o.smak@mail.com",
                "SMACZEK S.Z.O.O",
                "7765159402",
                "Krańcowa",
                "102",
                "Białystok",
                "15-057",
                "Polska"
        );

        Klient klient7 = new Klient(
                "Piotr",
                "Krakowiak",
                "502369878",
                "p.krakowiak@mail.com",
                "Krakowiak i Syn",
                "7661058302",
                "Warszawska",
                "102B/15",
                "Białystok",
                "15-058",
                "Polska"
        );

        Klient klient8 = new Klient(
                "Patrycja",
                "Piotrowska",
                "502987250",
                "p.piotrowska@mail.com",
                "Piotrowscy S.Z.O.O",
                "7691059102",
                "Poniatowskiego",
                "3B",
                "Białystok",
                "15-058",
                "Polska"
        );

        Klient klient9 = new Klient(
                "Karolina",
                "Lubomirska",
                "503981050",
                "k.lubomirska@mail.com",
                "Lubomirscy S.Z.O.O",
                "1061054270",
                "Piękna",
                "1B/10",
                "Białystok",
                "15-057",
                "Polska"
        );

        Klient klient10 = new Klient(
                "Aleksy",
                "Wir",
                "502369872",
                "a.wir@mail.com",
                "Wirownia",
                "2591052598",
                "Sienkiewicza",
                "52/15",
                "Białystok",
                "15-058",
                "Polska"
        );

        Faktura faktura1 = new Faktura();
        Faktura faktura2 = new Faktura();
        Faktura faktura3 = new Faktura();
        Faktura faktura4 = new Faktura();
        Faktura faktura5 = new Faktura();

        Zamowienie zamowienie1 = new Zamowienie(klient1, pracownik1);
        Pozycja pozycja1 = new Pozycja(10, towar1);
        pozycja1.setZamowienie(zamowienie1);
        Pozycja pozycja2 = new Pozycja(5, towar2);

        Zamowienie zamowienie2 = new Zamowienie(klient1, pracownik1);
        pozycja2.setZamowienie(zamowienie2);
        Pozycja pozycja3 = new Pozycja(5, towar3);
        pozycja3.setZamowienie(zamowienie2);
        Pozycja pozycja4 = new Pozycja(5, towar10);
        pozycja4.setZamowienie(zamowienie2);
        Pozycja pozycja5 = new Pozycja(5, towar12);
        pozycja5.setZamowienie(zamowienie2);

        Zamowienie zamowienie3 = new Zamowienie(klient1, pracownik1);
        Pozycja pozycja6 = new Pozycja(5, towar13);
        pozycja6.setZamowienie(zamowienie3);
        Pozycja pozycja7 = new Pozycja(10, towar1);
        pozycja7.setZamowienie(zamowienie3);

        zamowienie1.setFaktura(faktura1);
        zamowienie1.setStanZamowienia(StanZamowienia.DO_OPLATY);
        zamowienie2.setFaktura(faktura1);
        zamowienie3.setFaktura(faktura1);
        zamowienie2.setStanZamowienia(StanZamowienia.W_REALIZACJI);

        Zamowienie zamowienie4 = new Zamowienie(klient4, pracownik4);
        Pozycja pozycja8 = new Pozycja(10, towar29);
        pozycja8.setZamowienie(zamowienie4);
        Pozycja pozycja9 = new Pozycja(10, towar50);
        pozycja9.setZamowienie(zamowienie4);

        Zamowienie zamowienie5 = new Zamowienie(klient4, pracownik4);
        Pozycja pozycja10 = new Pozycja(10, towar48);
        pozycja10.setZamowienie(zamowienie5);
        Pozycja pozycja11 = new Pozycja(8, towar32);
        pozycja11.setZamowienie(zamowienie5);
        Pozycja pozycja12 = new Pozycja(10, towar19);
        pozycja12.setZamowienie(zamowienie5);
        Pozycja pozycja13 = new Pozycja(10, towar22);
        pozycja13.setZamowienie(zamowienie5);

        zamowienie4.setFaktura(faktura2);
        zamowienie5.setStanZamowienia(StanZamowienia.DO_OPLATY);
        zamowienie5.setFaktura(faktura2);

        Zamowienie zamowienie6 = new Zamowienie(klient7, pracownik7);
        Pozycja pozycja14 = new Pozycja(7, towar18);
        pozycja14.setZamowienie(zamowienie6);
        Pozycja pozycja15 = new Pozycja(5, towar35);
        pozycja15.setZamowienie(zamowienie6);
        Pozycja pozycja16 = new Pozycja(8, towar36);
        pozycja16.setZamowienie(zamowienie6);

        zamowienie6.setFaktura(faktura3);

        Zamowienie zamowienie8 = new Zamowienie(klient9, pracownik9);
        Pozycja pozycja17 = new Pozycja(10, towar43);
        pozycja17.setZamowienie(zamowienie8);
        Pozycja pozycja18 = new Pozycja(8, towar36);
        pozycja18.setZamowienie(zamowienie8);
        Pozycja pozycja19 = new Pozycja(15, towar27);
        pozycja19.setZamowienie(zamowienie8);
        Pozycja pozycja20 = new Pozycja(10, towar26);
        pozycja20.setZamowienie(zamowienie8);

        zamowienie8.setFaktura(faktura4);

        Zamowienie zamowienie9 = new Zamowienie(klient3, pracownik3);
        Pozycja pozycja21 = new Pozycja(16, towar25);
        pozycja21.setZamowienie(zamowienie9);
        Pozycja pozycja22 = new Pozycja(13, towar35);
        pozycja22.setZamowienie(zamowienie9);

        zamowienie9.setStanZamowienia(StanZamowienia.W_REALIZACJI);
        zamowienie9.setFaktura(faktura5);


//        Faktura faktura = new Faktura();
//        Zamowienie zamowienie1 = new Zamowienie(klient, pracownik);
//        Zamowienie zamowienie2 = new Zamowienie(klient, pracownik);
//        Pozycja pozycja1 = new Pozycja(2, towar1);
////        Pozycja pozycja2 = new Pozycja( 10, towar1);
//        Pozycja pozycja3 = new Pozycja(2, towar2);
//
////        Zamowienie zamowienie3 = new Zamowienie(klient, pracownik);
//
//        pozycja1.setZamowienie(zamowienie1);
////        pozycja2.setZamowienie(zamowienie3);
//        pozycja3.setZamowienie(zamowienie2);
//
//        zamowienie1.setFaktura(faktura);
//        zamowienie2.setFaktura(faktura);
//        zamowienie2.setStanZamowienia(StanZamowienia.W_REALIZACJI);


//        Zamowienie zamowienie1 = new Zamowienie(klient, pracownik, Set.of(pozycja1, pozycja2));
//        Zamowienie zamowienie2 = new Zamowienie(klient, pracownik, Set.of(pozycja3));
//        zamowienie1.setFaktura(faktura);


        producentRepository.save(producent1);
        producentRepository.save(producent2);
        producentRepository.save(producent3);
        producentRepository.save(producent4);
        producentRepository.save(producent5);
        producentRepository.save(producent6);
        producentRepository.save(producent7);

        stanowiskoRepository.save(stanowisko1);
        stanowiskoRepository.save(stanowisko2);
        stanowiskoRepository.save(stanowisko3);

        pracownikRepository.save(pracownik1);
        pracownikRepository.save(pracownik2);
        pracownikRepository.save(pracownik3);
        pracownikRepository.save(pracownik4);
        pracownikRepository.save(pracownik5);
        pracownikRepository.save(pracownik6);
        pracownikRepository.save(pracownik7);
        pracownikRepository.save(pracownik8);
        pracownikRepository.save(pracownik9);
        pracownikRepository.save(pracownik10);

        kategoriaRepository.save(kategoria1);
        kategoriaRepository.save(kategoria2);
        kategoriaRepository.save(kategoria3);
        kategoriaRepository.save(kategoria4);
        kategoriaRepository.save(kategoria5);
        kategoriaRepository.save(kategoria6);
        kategoriaRepository.save(kategoria7);
        kategoriaRepository.save(kategoria8);

        rabatRepository.save(rabat1);
        rabatRepository.save(rabat2);
        rabatRepository.save(rabat3);
        rabatRepository.save(rabat4);

        towarRepository.save(towar1);
        towarRepository.save(towar2);
        towarRepository.save(towar3);
        towarRepository.save(towar4);
        towarRepository.save(towar5);
        towarRepository.save(towar6);
        towarRepository.save(towar7);
        towarRepository.save(towar8);
        towarRepository.save(towar9);
        towarRepository.save(towar10);
        towarRepository.save(towar11);
        towarRepository.save(towar12);
        towarRepository.save(towar13);
        towarRepository.save(towar14);
        towarRepository.save(towar15);
        towarRepository.save(towar16);
        towarRepository.save(towar17);
        towarRepository.save(towar18);
        towarRepository.save(towar19);
        towarRepository.save(towar20);
        towarRepository.save(towar21);
        towarRepository.save(towar22);
        towarRepository.save(towar23);
        towarRepository.save(towar24);
        towarRepository.save(towar25);
        towarRepository.save(towar26);
        towarRepository.save(towar27);
        towarRepository.save(towar28);
        towarRepository.save(towar29);
        towarRepository.save(towar30);
        towarRepository.save(towar31);
        towarRepository.save(towar32);
        towarRepository.save(towar33);
        towarRepository.save(towar34);
        towarRepository.save(towar35);
        towarRepository.save(towar36);
        towarRepository.save(towar37);
        towarRepository.save(towar38);
        towarRepository.save(towar39);
        towarRepository.save(towar40);
        towarRepository.save(towar41);
        towarRepository.save(towar42);
        towarRepository.save(towar43);
        towarRepository.save(towar44);
        towarRepository.save(towar45);
        towarRepository.save(towar46);
        towarRepository.save(towar47);
        towarRepository.save(towar48);
        towarRepository.save(towar49);
        towarRepository.save(towar50);

        klientService.save(klient1);
        klientService.save(klient2);
        klientService.save(klient3);
        klientService.save(klient4);
        klientService.save(klient5);
        klientService.save(klient6);
        klientService.save(klient7);
        klientService.save(klient8);
        klientService.save(klient9);
        klientService.save(klient10);

        fakturaRepository.save(faktura1);
        fakturaRepository.save(faktura2);
        fakturaRepository.save(faktura3);
        fakturaRepository.save(faktura4);
        fakturaRepository.save(faktura5);

        zamowienieRepository.save(zamowienie1);
        zamowienieRepository.save(zamowienie2);
        zamowienieRepository.save(zamowienie3);
        zamowienieRepository.save(zamowienie4);
        zamowienieRepository.save(zamowienie5);
        zamowienieRepository.save(zamowienie6);
        zamowienieRepository.save(zamowienie8);
        zamowienieRepository.save(zamowienie9);
        zamowienieRepository.save(zamowienie1);

        pozycjaRepository.save(pozycja1);
        pozycjaRepository.save(pozycja2);
        pozycjaRepository.save(pozycja3);
        pozycjaRepository.save(pozycja4);
        pozycjaRepository.save(pozycja5);
        pozycjaRepository.save(pozycja6);
        pozycjaRepository.save(pozycja7);
        pozycjaRepository.save(pozycja8);
        pozycjaRepository.save(pozycja9);
        pozycjaRepository.save(pozycja10);
        pozycjaRepository.save(pozycja11);
        pozycjaRepository.save(pozycja12);
        pozycjaRepository.save(pozycja13);
        pozycjaRepository.save(pozycja14);
        pozycjaRepository.save(pozycja15);
        pozycjaRepository.save(pozycja16);
        pozycjaRepository.save(pozycja17);
        pozycjaRepository.save(pozycja18);
        pozycjaRepository.save(pozycja19);
        pozycjaRepository.save(pozycja20);
        pozycjaRepository.save(pozycja21);
        pozycjaRepository.save(pozycja22);
    }
}
