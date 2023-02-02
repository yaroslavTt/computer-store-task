package com.example.app.model.properties;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "processors")
@Data
public class Processor extends Property{

    @Column
    private Integer cores;
}
