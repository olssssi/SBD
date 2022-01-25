package com.example.demo.file.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomDocument extends Document{
    public static final class Builder {

        private HttpServletResponse response;
        private String fileName;
        private String location;
        private Rectangle pageSize;
        private String title;
        private float paddingTopTitle;
        private float paddingBottomTitle;
        private float marginLeft;
        private float marginTop;
        private float marginRight;
        private float marginBottom;
        private ByteArrayOutputStream byteArrayOutputStream;

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder response(HttpServletResponse response) {
            this.response = response;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder pageSize(Rectangle pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder marginLeft(float marginLeft){
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder marginTop(float marginTop){
            this.marginTop = marginTop;
            return this;
        }

        public Builder marginRight(float marginRight){
            this.marginRight = marginRight;
            return this;
        }

        public Builder marginBottom(float marginBottom){
            this.marginBottom = marginBottom;
            return this;
        }

        public Builder paddingTopTitle(float paddingTopTitle){
            this.paddingTopTitle = paddingTopTitle;
            return this;
        }

        public Builder paddingBottomTitle(float paddingBottomTitle){
            this.paddingBottomTitle = paddingBottomTitle;
            return this;
        }

        public Document build(Document document) throws DocumentException, IOException {
            PdfWriter.getInstance(document,new FileOutputStream(this.location+this.fileName));
            document.setMargins(this.marginLeft, this.marginRight, this.marginTop, this.marginBottom);
            document.addTitle(this.title);
            document.open();

            Paragraph paragraph = new Paragraph(this.title);
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph.setSpacingBefore(this.paddingTopTitle);
            paragraph.setSpacingAfter(this.paddingBottomTitle);
            document.add(paragraph);

            return document;
        }
    }
}

