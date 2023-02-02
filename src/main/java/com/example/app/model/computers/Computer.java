package com.example.app.model.computers;
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

    @Column(name="storage_memory")
    private Integer storageMemory;

    @Column(name="operative_memory")
    private Integer operativeMemory;
}
