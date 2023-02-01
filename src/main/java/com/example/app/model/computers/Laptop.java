package com.example.app.model.computers;

import com.example.app.model.properties.Display;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "laptops")
@Data
public class Laptop extends Computer{

    @ManyToOne
    @JoinColumn(name = "display_id", referencedColumnName = "id")
    private Display display;
}
