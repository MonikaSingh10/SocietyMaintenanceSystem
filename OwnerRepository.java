package com.room.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.room.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByPendingAmountGreaterThan(double amount);
}
