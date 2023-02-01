package com.example.app.model.computers;

import com.example.app.model.properties.HardDrive;
import com.example.app.model.properties.Motherboard;
import com.example.app.model.properties.OperativeMemory;
import com.example.app.model.properties.Processor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@MappedSuperclass
@Data
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "processor_id", referencedColumnName = "id")
    private Processor processor;

    @OneToOne()
    @JoinColumn(name = "motherboard_id", referencedColumnName = "id")
    private Motherboard motherboard;

    @OneToOne()
    @JoinColumn(name = "hard_drive_id", referencedColumnName = "id")
    private HardDrive hardDrive;

    @OneToOne()
    @JoinColumn(name = "operative_memory_id", referencedColumnName = "id")
    private OperativeMemory operativeMemory;
}
