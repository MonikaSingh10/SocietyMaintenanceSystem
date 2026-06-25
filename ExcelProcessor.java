package com.room.common;

import com.room.entity.Employee;
import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.InputStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ExcelProcessor {

    private ExcelProcessor() {}

    public static Stream<Employee> process(InputStream is) {

        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100)      // rows kept in memory
                .bufferSize(4096)       // read buffer
                .open(is);

        Sheet sheet = workbook.getSheetAt(0);

        return StreamSupport.stream(sheet.spliterator(), false)
                .skip(1) // skip header
                .map(row -> mapRow(row));
    }

    private static Employee mapRow(Row row) {

        Employee e = new Employee();

        e.setName(row.getCell(0).getStringCellValue().trim());
        e.setEmail(row.getCell(1).getStringCellValue().trim());
        e.setSalary(row.getCell(2).getNumericCellValue());

        return e;
    }
}
