package com.example.demo.file;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/pliki")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/pdf/{id}")
    public ResponseEntity<HttpStatus> exportToPdf(@PathVariable Long id, HttpServletResponse response) throws IllegalAccessException, DocumentException, IOException {
        fileService.exportCandidatesToPdf(id, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}