package com.example.app.model.properties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "operative_memories")
@Data
public class OperativeMemory extends Property{
    private Integer memoryAmount;
}
