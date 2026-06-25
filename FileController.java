package com.room.controller;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.room.common.CsvProcessor;
import com.room.common.DocxProcessor;
import com.room.common.ExcelProcessor;
import com.room.common.FileTypeDetector;
import com.room.common.PdfProcessor;
import com.room.common.TxtProcessor;
import com.room.entity.Employee;
import com.room.service.FileService;

@Controller
public class FileController {

    @Autowired
    private FileService service;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws Exception {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        FileTypeDetector.FileType type =  FileTypeDetector.detect(file.getOriginalFilename());
        System.out.println("type::::"+type);
        Stream<Employee> stream;

        switch (type) {
            case CSV:
                stream = CsvProcessor.process(file.getInputStream());
                break;

            case TXT:
                stream = TxtProcessor.process(file.getInputStream());
                break;

            case EXCEL:
                stream = ExcelProcessor.process(file.getInputStream());
                break;

            case PDF:
                stream = PdfProcessor.process(file.getInputStream());
                break;

            case DOCX:
                stream = DocxProcessor.process(file.getInputStream());
                break;

            default:
                throw new RuntimeException("Unsupported file type");
        }

        service.save(stream);
        
        redirectAttributes.addFlashAttribute("success", "File uploaded and data inserted successfully ✅" );

        return "redirect:/admin/dashboard";
    }
}
