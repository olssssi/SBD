package com.example.demo.file;

import com.example.demo.faktura.Faktura;
import com.example.demo.faktura.FakturaRepository;
import com.example.demo.file.pdf.PdfResolver;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieRepository;
import com.itextpdf.text.DocumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private ZamowienieRepository zamowienieRepository;

    @Autowired
    private FakturaRepository fakturaRepository;

    private static final Logger logger = LogManager.getLogger(FileService.class);

    private String convertDate(OffsetDateTime date){
        return "_"+date.getDayOfMonth()+"_"+date.getMonthValue()+"_"+date.getHour()+"_"+date.getHour()+"_"+date.getMinute();
    }

    public FileDto exportCandidatesToPdf(Long fakturaId, HttpServletResponse response) throws IllegalAccessException, DocumentException, IOException {
        Faktura faktura = fakturaRepository.getById(fakturaId);
        String fileName="faktura"+convertDate(faktura.getDataRealizacji())+".pdf";
        String home = System.getProperty("user.home");
        String path = home+"/Downloads/";

        List<Zamowienie> zamowienieList = zamowienieRepository.findByFaktura(faktura);
        PdfResolver helper = new PdfResolver(zamowienieList);
        byte[] bytes = helper.createPdf(path, fileName);


        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+fileName;
        response.setContentType("application/pdf");
        response.setHeader(headerKey, headerValue);

        FileOutputStream fos = new FileOutputStream(path + fileName);
        fos.write(bytes);
        return new FileDto(fileName, bytes);

    }
}