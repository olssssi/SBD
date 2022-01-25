package com.example.demo.file.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class CustomCell extends PdfPCell {
    public static final class Builder {
        private String text;
        private Font font;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder font(Font font) {
            this.font = font;
            return this;
        }

        public PdfPCell build() {
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Phrase(this.text, this.font));
            return cell;
        }
    }
}
