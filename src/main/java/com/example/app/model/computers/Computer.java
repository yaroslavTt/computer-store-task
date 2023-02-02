package com.example.app.model.computers;
import com.example.app.model.properties.GraphicCard;
import com.example.app.model.properties.HardDrive;
import com.example.app.model.properties.OperativeMemory;
import com.example.app.model.properties.Processor;
import jakarta.persistence.*;
import lombok.*;

@Table(name="computers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "processor_id", referencedColumnName = "id")
    private Processor processor;

    @OneToOne
    @JoinColumn(name = "graphic_card_id", referencedColumnName = "id")
    private GraphicCard graphicCard;

    @OneToOne
    @JoinColumn(name="hard_drive_id", referencedColumnName = "id")
    private HardDrive storage;

    @OneToOne
    @JoinColumn(name="operative_memory_id", referencedColumnName = "id")
    private OperativeMemory operativeMemory;
}
