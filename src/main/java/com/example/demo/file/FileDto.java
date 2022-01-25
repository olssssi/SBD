package com.example.demo.file;

public class FileDto {
    private String fileName;
    private byte[] contentFile;

    public FileDto(String fileName, byte[] contentFile) {
        this.fileName = fileName;
        this.contentFile = contentFile;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getContentFile() {
        return contentFile;
    }
}
