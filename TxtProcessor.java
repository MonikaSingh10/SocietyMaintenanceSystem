package com.room.common;

import com.room.entity.Employee;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class TxtProcessor {

    private TxtProcessor() {}

    public static Stream<Employee> process(InputStream is) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8), 1024 * 1024);

        return reader.lines()
                .skip(1) // ✅ skip header row
                .map(line -> {
                    String[] data = line.split(",", -1);

                    System.out.println("data:::: " + line);

                    Employee e = new Employee();
                    e.setName(data[0].trim());
                    e.setEmail(data[1].trim());
                    e.setSalary(Double.parseDouble(data[2].trim()));

                    return e;
                });

    }
}
