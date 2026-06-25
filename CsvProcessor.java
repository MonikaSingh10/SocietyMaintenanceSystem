package com.room.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import com.room.entity.Employee;

public class CsvProcessor {

    private CsvProcessor() {}

    public static Stream<Employee> process(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8), 1024 * 1024);

        return reader.lines()
                .skip(1) // skip header
                .map(line -> {
                    String[] data = line.split(",", -1);

                    Employee e = new Employee();
                    e.setName(data[0].trim());
                    e.setEmail(data[1].trim());
                    e.setSalary(Double.parseDouble(data[2].trim()));

                    return e;
                });
    }
}
