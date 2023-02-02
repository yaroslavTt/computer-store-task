package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hard_drives")
@Data
public class HardDrive extends Property{

    @Column(name = "storage_memory")
    private Integer storageMemory;
}
