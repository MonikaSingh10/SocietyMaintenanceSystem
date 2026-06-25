package com.room.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flat_No")
    private String flatNumber;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL)
    private List<MaintenanceBill> bills;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<MaintenanceBill> getBills() {
		return bills;
	}

	public void setBills(List<MaintenanceBill> bills) {
		this.bills = bills;
	}

    // Getters/Setters
}
