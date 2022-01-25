package com.example.demo.file.pdf;

import com.example.demo.annotation.ExcludeFromExport;
import com.example.demo.klient.Klient;
import com.example.demo.pracownik.Pracownik;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CustomTable extends PdfPTable {

    public static final class Builder<T>{
        private int numberOfColumns;
        private int spacingBefore;
        private int spacingAfter;
        private List<T> objectList;
        private String headerFontStyle;
        private String dataFontStyle;
        private float headerFontSize;
        private float dataFontSize;
        private int widthPercentage;

        public Builder widthPercentage(int widthPercentage){
            this.widthPercentage = widthPercentage;
            return this;
        }

        public Builder paddingTop(int spacingBefore) {
            this.spacingBefore = spacingBefore;
            return this;
        }

        public Builder paddingBottom(int spacingAfter) {
            this.spacingAfter = spacingAfter;
            return this;
        }

        public Builder objectList(List<T> objectList){
            this.objectList = objectList;
            return this;
        }

        public Builder headerFontStyle(String headerFontStyle){
            this.headerFontStyle = headerFontStyle;
            return this;
        }

        public Builder dataFontStyle(String dataFontStyle) {
            this.dataFontStyle = dataFontStyle;
            return this;
        }

        public Builder headerFontSize(float headerFontSize) {
            this.headerFontSize = headerFontSize;
            return this;
        }

        public Builder dataFontSize(float dataFontSize) {
            this.dataFontSize = dataFontSize;
            return this;
        }

        public PdfPTable build() throws IllegalAccessException {
            this.numberOfColumns = countColumnsToExport();
            PdfPTable pTable = new PdfPTable(this.numberOfColumns);
            pTable.setSpacingBefore(this.spacingBefore);
            pTable.setSpacingAfter(this.spacingAfter);
            pTable.setWidthPercentage(this.widthPercentage);


            List<Field> headers = writeHeaders(pTable);
            writeData(pTable, headers);

            return pTable;
        }

        private int countColumnsToExport(){
            int counter=0;
            for(Field field : objectList.get(0).getClass().getDeclaredFields()){
                if(!field.isAnnotationPresent(ExcludeFromExport.class))
                    counter++;
            }
            return counter;
        }

        private void writeRow(PdfPTable pTable, Object[] objects, Font font){
            for (Object object : objects) {
                PdfPCell cell = new CustomCell.Builder()
                        .text(convertValue(object))
                        .font(font)
                        .build();
                pTable.addCell(cell);
            }
        }

        private String convertValue(Object object){
            if(object.getClass() == Pracownik.class){
                return ((Pracownik) object).convert();
            } else if(object.getClass() == Klient.class){
                return ((Klient) object).convert();
            } else return String.valueOf(object);
        }

        private List<Field> writeHeaders(PdfPTable pTable){
            Font font = FontFactory.getFont(this.headerFontStyle); //String.valueOf(BaseFont.EMBEDDED)
            font.setSize(this.headerFontSize);

            Field[] fields = objectList.get(0).getClass().getDeclaredFields();
            Field[] annotatedFields = new Field[this.numberOfColumns];
            Object[] headers = new Object[this.numberOfColumns];
            for(int i=0, j=0; i<8; i++){
                if(fields[i].isAnnotationPresent(ExcludeFromExport.class))
                    continue;
                headers[j]=fields[i].getName();
                annotatedFields[j]=fields[i];
                j++;
            }
            writeRow(pTable, headers, font);
            return Arrays.asList(annotatedFields);
        }

        private void writeData(PdfPTable pTable, List<Field> headers) throws IllegalAccessException {
            Font font = FontFactory.getFont(this.dataFontStyle); //String.valueOf(BaseFont.EMBEDDED)
            font.setSize(this.dataFontSize);

            for(T object : objectList){
                Object[] objects = new Object[this.numberOfColumns];
                for(int i = 0 ; i < headers.size() ; i++){
                    Field header = headers.get(i);
                    header.setAccessible(true);
                    Object objectByHeader = header.get(object);
                    objects[i] = objectByHeader;
                }
                writeRow(pTable, objects, font);
            }
        }
    }
}
