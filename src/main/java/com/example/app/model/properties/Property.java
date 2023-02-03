package com.example.app.model.properties;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "component_name")
    private String componentName;

    @Column(name = "price")
    private Double price;

    @Column(name = "details")
    private String details;
}
