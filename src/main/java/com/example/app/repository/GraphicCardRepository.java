package com.example.app.repository;

import com.example.app.model.properties.GraphicCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCard, Long> {
}
