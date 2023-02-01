package com.example.app.repository;

import com.example.app.model.properties.OperativeMemory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperativeMemoryRepository extends JpaRepository<OperativeMemory, Long> {
}
