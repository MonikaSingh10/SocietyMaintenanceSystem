package com.room.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.room.entity.MaintenanceBill;

public interface BillRepository extends JpaRepository<MaintenanceBill, Long> {
List<MaintenanceBill> findByFlatId(Long flatId);
}