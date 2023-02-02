package com.example.app.service;

import com.example.app.model.category.Category;
import com.example.app.model.computers.Computer;
import com.example.app.repository.CategoryRepository;
import com.example.app.repository.ComputerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final CategoryRepository categoryRepository;

    public List<Computer> getComputersByCategoryName(String categoryName){
        Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
    }

}
