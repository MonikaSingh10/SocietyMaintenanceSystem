package com.room.common;

public class FileTypeDetector {

    public enum FileType {
        CSV, TXT, EXCEL, PDF, DOCX
    }

    public static  FileType detect(String filename) {

        if (filename == null) {
            throw new IllegalArgumentException("Filename is null");
        }

        String name = filename.toLowerCase();

        if (name.endsWith(".csv")) return FileType.CSV;
        if (name.endsWith(".txt")) return FileType.TXT;
        if (name.endsWith(".xlsx")) return FileType.EXCEL;
        if (name.endsWith(".pdf")) return FileType.PDF;        
        if (name.endsWith(".docx")) return FileType.DOCX;

        throw new IllegalArgumentException("Unsupported file type: " + filename);
    }
}
