package com.example.app.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="min_storage_memory")
    private Double minStorageMemory;

    @Column(name="min_cpu_cores")
    private Integer minCpuCores;

    @Column(name="max_cpu_cores")
    private Integer maxCpuCores;

    @Column(name="min_operative_memory")
    private Integer minOperativeMemory;

    @Column(name="max_operative_memory")
    private Integer maxOperativeMemory;

    @Column(name="min_video_memory")
    private Integer minimalVideoMemory;

    @Column(name="max_video_memory")
    private Integer maxVideoMemory;
}
