package com.room.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.room.entity.MaintenanceBill1;

public interface MaintenanceBill1Repository extends JpaRepository<MaintenanceBill1, Long> {

    @Query("SELECT b FROM MaintenanceBill1 b JOIN FETCH b.owner")
    List<MaintenanceBill1> findAllWithOwner();
}
