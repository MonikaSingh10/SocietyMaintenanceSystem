package com.room.common;

import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import com.room.entity.Employee;

public class DocxProcessor {

    private DocxProcessor() {}

    public static Stream<Employee> process(InputStream is) {

        try (XWPFDocument document = new XWPFDocument(is);
             XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {

            String text = extractor.getText();

            return Arrays.stream(text.split("\\r?\\n"))
                    .skip(1)
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .map(DocxProcessor::mapToEmployee)
                    .filter(e -> e != null);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read DOCX file", e);
        }
    }

    private static Employee mapToEmployee(String line) {
    	 String[] data = line.split("\\s+");

        if (data.length < 3) return null;

        try {
            Employee e = new Employee();
            e.setName(data[0].trim());
            e.setEmail(data[1].trim());
            e.setSalary(Double.parseDouble(data[2].trim()));
            return e;
        } catch (Exception ex) {
            return null;
        }
    }
}
