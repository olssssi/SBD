package com.example.demo.file.pdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfResolver<T> {

    private final List<T> objectList;

    public PdfResolver(List<T> objectList) {
        this.objectList = objectList;
    }

    public byte[] createPdf(String location, String fileName) throws IllegalAccessException, DocumentException, IOException {

        Document document = new Document(com.itextpdf.text.PageSize.A4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);

        document = new CustomDocument.Builder()
                .fileName(fileName)
                .location(location)
                .pageSize(com.itextpdf.text.PageSize.A4)
//                .title(objectList.get(0).getClass().getSimpleName().toUpperCase())
                .title(fileName.toUpperCase().split(".PDF")[0])
                .paddingTopTitle(5)
                .paddingBottomTitle(10)
                .marginLeft(10)
                .marginTop(10)
                .marginRight(10)
                .marginBottom(10)
                .build(document);

        PdfPTable pTable = new CustomTable.Builder()
                .paddingTop(15)
                .paddingBottom(10)
                .objectList(objectList)
                .headerFontStyle(FontFactory.TIMES_BOLD)
                .headerFontSize(11)
                .dataFontStyle(FontFactory.TIMES_ROMAN)
                .dataFontSize(10)
                .widthPercentage(100)
                .build();

        document.add(pTable);
        document.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;
    }

}
