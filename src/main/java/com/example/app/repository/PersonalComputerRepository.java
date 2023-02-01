package com.example.app.repository;

import com.example.app.model.computers.PersonalComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalComputerRepository extends JpaRepository<PersonalComputer, Long> {
}
