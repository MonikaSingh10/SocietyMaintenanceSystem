package com.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.room.entity.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long> {}