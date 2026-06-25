package com.room.service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.room.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class FileService {

    private static final int BATCH_SIZE = 1000;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Stream<Employee> stream) {

        AtomicInteger counter = new AtomicInteger();

        stream.forEach(emp -> {
            entityManager.persist(emp);

            if (counter.incrementAndGet() % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        });

        entityManager.flush();
        entityManager.clear();
    }
}
