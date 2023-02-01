package com.example.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="components")
@Data
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "component_type")
    private ComponentType componentType;

    @Column(name = "component_price")
    private Double componentPrice;

    @Column(name = "component_details")
    private String componentDetails;
}
