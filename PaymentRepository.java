package com.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.room.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}