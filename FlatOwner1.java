package com.room.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flat_owner")
public class FlatOwner1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String flatNo;
    private boolean active;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFlatNo() { return flatNo; }
    public void setFlatNo(String flatNo) { this.flatNo = flatNo; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
