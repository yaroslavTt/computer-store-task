package com.example.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Table(name = "computers")
@Entity
@Data
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="computer_type")
    private ComputerType computerType;

    @ManyToMany
    @JoinTable(
            name = "computer_components",
            joinColumns = @JoinColumn(name="component_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id")
    )
    private Set<Component> components = new HashSet<>();

}
