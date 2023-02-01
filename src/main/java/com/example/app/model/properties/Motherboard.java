package com.example.app.model.properties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "motherboards")
@Data
public class Motherboard extends Property{

    @Column
    private String socket;
}
