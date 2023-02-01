package com.example.app.model.properties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Entity
@Table(name = "displays")
@Data
public class Display extends Property{

    @Column
    @Pattern(regexp = "\\d{3}\\d?x\\d{3}\\d?",
            message = "Wrong resolution format.")
    private String resolution;
}
