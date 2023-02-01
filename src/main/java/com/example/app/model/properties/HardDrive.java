package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="hard_drives")
@Data
public class HardDrive extends Property{

    @Column
    private Double capacity;
}
