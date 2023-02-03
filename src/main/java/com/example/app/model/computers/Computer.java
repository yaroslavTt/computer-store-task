package com.example.app.model.computers;
import com.example.app.model.properties.GraphicCard;
import com.example.app.model.properties.HardDrive;
import com.example.app.model.properties.OperativeMemory;
import com.example.app.model.properties.Processor;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private Processor processor;

    @OneToOne
    @JoinColumn(name = "graphic_card_id", referencedColumnName = "id")
    @NotNull
    private GraphicCard graphicCard;

    @OneToOne
    @JoinColumn(name="hard_drive_id", referencedColumnName = "id")
    @NotNull
    private HardDrive storage;

    @OneToOne
    @JoinColumn(name="operative_memory_id", referencedColumnName = "id")
    @NotNull
    private OperativeMemory operativeMemory;

    @Transient
    public Double getPrice(){
        return processor.getPrice() + graphicCard.getPrice() + storage.getPrice() + operativeMemory.getPrice();
    }
}
