package com.room.common;

import com.room.entity.Employee;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

public class PdfProcessor {

    private PdfProcessor() {}

    public static Stream<Employee> process(InputStream is) {

        try (PDDocument document = PDDocument.load(is)) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            return Arrays.stream(text.split("\\r?\\n"))
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .filter(line -> !line.toLowerCase().startsWith("mailto")) // ❌ skip garbage
                    .filter(line -> !line.toLowerCase().startsWith("name"))   // ❌ skip header
                    .map(PdfProcessor::parseLine)
                    .filter(e -> e != null);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read PDF file", e);
        }
    }

    private static Employee parseLine(String line) {

        // split by MULTIPLE SPACES (PDF safe)
        String[] data = line.split("\\s+");
         System.out.println("data::"+data);
        if (data.length < 3) {
            return null; // skip bad rows
        }

        try {
            Employee e = new Employee();
            e.setName(data[0]);
            e.setEmail(data[1]);
            e.setSalary(Double.parseDouble(data[2]));
            return e;
        } catch (Exception ex) {
            return null; // skip invalid salary rows
        }
    }
}
