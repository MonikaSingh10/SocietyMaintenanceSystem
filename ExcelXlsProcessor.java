package com.room.common;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import com.room.entity.Employee;

public class ExcelXlsProcessor {

    public static Stream<Employee> process(InputStream is) throws Exception {

        Workbook workbook = new HSSFWorkbook(is);   // .xls reader
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        // Skip header
        if (iterator.hasNext()) iterator.next();

        Spliterator<Row> spliterator =
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);

        return StreamSupport.stream(spliterator, false)
                .map(ExcelXlsProcessor::mapRow)
                .onClose(() -> {
                    try { workbook.close(); } catch (Exception ignored) {}
                });
    }

    private static Employee mapRow(Row row) {

        Employee e = new Employee();
        e.setName(getCellValue(row.getCell(0)));
        e.setEmail(getCellValue(row.getCell(1)));
        e.setSalary(Double.parseDouble(getCellValue(row.getCell(2))));
        return e;
        
    }

    private static String getCellValue(Cell cell) {

        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }
}
