package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="graphic_cards")
@Entity
@Data
public class GraphicCard extends Property{

    @Column(name = "video_memory")
    private Double videoMemory;
}
