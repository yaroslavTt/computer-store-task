package com.example.app.service;

import com.example.app.model.category.Category;
import com.example.app.model.computers.Computer;
import com.example.app.repository.CategoryRepository;
import com.example.app.repository.ComputerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final CategoryService categoryService;

    public List<Computer> getAllComputers(){
        return computerRepository.findAll();
    }

    public Computer getComputer(Long id){
        return computerRepository.findById(id).orElseThrow(() -> new NotYetImplementedException(""));
    }

    public Computer saveComputer(Computer computer){
        return computerRepository.save(computer);
    }
    public List<Computer> getComputersByCategoryName(String categoryName){
        Category category = categoryService.getCategoryByName(categoryName);

        return computerRepository.findAllByCategory(category.getMinStorageMemory(),
                                                    category.getMinOperativeMemory(),
                                                    category.getMaxOperativeMemory(),
                                                    category.getMinVideoMemory(),
                                                    category.getMaxVideoMemory(),
                                                    category.getMinCpuCores(),
                                                    category.getMaxCpuCores());
    }

}
