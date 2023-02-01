package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "power_supplies")
@Data
public class PowerSupply extends Property{

    @Column
    private Double power;

    @Column
    private Boolean modular;
}
