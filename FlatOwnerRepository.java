package com.room.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.room.entity.FlatOwner1;

public interface FlatOwnerRepository extends JpaRepository<FlatOwner1, Long> {

    @Query("""
        SELECT o FROM FlatOwner1 o
        WHERE lower(o.name) LIKE lower(concat('%', :keyword, '%'))
           OR lower(o.flatNo) LIKE lower(concat('%', :keyword, '%'))
    """)
    List<FlatOwner1> searchByNameOrFlat(@Param("keyword") String keyword);
}
