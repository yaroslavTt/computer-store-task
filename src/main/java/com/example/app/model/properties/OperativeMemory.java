package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="operative_memories")
public class OperativeMemory extends Property{

    @Column
    private Double frequency;

    @Column
    private Double capacity;
}
