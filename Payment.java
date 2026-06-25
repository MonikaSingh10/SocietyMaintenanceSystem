package com.room.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDate paymentDate;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private MaintenanceBill bill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public MaintenanceBill getBill() {
		return bill;
	}

	public void setBill(MaintenanceBill bill) {
		this.bill = bill;
	}

    // Getters/Setters
}
