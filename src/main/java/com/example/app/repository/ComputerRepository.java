package com.example.app.repository;

import com.example.app.model.computers.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    @Query(value="FROM Computer c WHERE c.operativeMemory.memoryAmount BETWEEN :minOperativeMemory AND :maxOperativeMemory " +
                 "AND c.processor.cores BETWEEN :minCpuCores AND :maxCpuCores " +
                 "AND c.graphicCard.videoMemory BETWEEN :minVideoMemory AND :maxVideoMemory " +
                 "AND c.storage.storageMemory >= :minStorageMemory")
    List<Computer> findAllByCategory(@Param("minStorageMemory") Integer minStorageMemory,
                                     @Param("minOperativeMemory") Integer minOperativeMemory,
                                     @Param("maxOperativeMemory") Integer maxOperativeMemory,
                                     @Param("minVideoMemory") Integer minVideoMemory,
                                     @Param("maxVideoMemory") Integer maxVideoMemory,
                                     @Param("minCpuCores") Integer minCpuCores,
                                     @Param("maxCpuCores") Integer maxCpuCores);
}
