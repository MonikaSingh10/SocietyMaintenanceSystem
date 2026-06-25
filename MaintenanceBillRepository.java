package com.room.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.room.entity.MaintenanceBill;

@Repository
public interface MaintenanceBillRepository 
        extends JpaRepository<MaintenanceBill, Long> {

    @Query("SELECT b FROM MaintenanceBill b WHERE b.paid = false AND b.dueDate <= CURRENT_DATE")
    List<MaintenanceBill> findPendingBills();
    
 // ✅ Avoid LazyInitializationException
    @Query("SELECT b FROM MaintenanceBill1 b JOIN FETCH b.owner")
    List<MaintenanceBill> findAllWithOwner();
    
}
