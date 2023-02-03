package com.example.app.service;

import com.example.app.exception.CategoryAlreadyExistsException;
import com.example.app.exception.CategoryNotFoundException;
import com.example.app.model.category.Category;
import com.example.app.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private static final Integer MAX_OPERATIVE_MEMORY_IF_ABSENT = 512;
    private static final Integer MAX_VIDEO_MEMORY_IF_ABSENT = 32;
    private static final Integer MAX_CPU_CORES_IF_ABSENT = 32;
    private final CategoryRepository categoryRepository;

    public void createCategory(Category category){
        if(categoryRepository.findByCategoryName(category.getCategoryName()).isPresent()){
            throw new CategoryAlreadyExistsException("Category with name: " + category.getCategoryName() + " already exists.");
        }
        categoryRepository.save(category);
    }

    public void updateCategory(Long categoryId, Category updateCategory){
        Category category = getCategoryById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setMinCpuCores(updateCategory.getMinCpuCores());
        category.setMinVideoMemory(updateCategory.getMinVideoMemory());
        category.setMinStorageMemory(updateCategory.getMinStorageMemory());
        category.setMinOperativeMemory(updateCategory.getMinOperativeMemory());
        category.setMaxCpuCores(updateCategory.getMaxCpuCores());
        category.setMaxVideoMemory(updateCategory.getMaxVideoMemory());
        category.setMaxOperativeMemory(updateCategory.getMaxOperativeMemory());
        categoryRepository.save(category);
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return validateCategory(optionalCategory
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId)));
    }

    public Category getCategoryByName(String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findByCategoryName(categoryName);
        return validateCategory(optionalCategory
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: " + categoryName)));
    }

    private Category validateCategory(Category category){
        if (category.getMinCpuCores() == null){
            category.setMinCpuCores(-1);
        }
        if(category.getMinStorageMemory() == null){
            category.setMinStorageMemory(-1);
        }
        if (category.getMinOperativeMemory() == null){
            category.setMinOperativeMemory(-1);
        }
        if (category.getMinVideoMemory() == null){
            category.setMinVideoMemory(-1);
        }
        if (category.getMaxCpuCores() == null){
            category.setMaxCpuCores(MAX_CPU_CORES_IF_ABSENT);
        }
        if (category.getMaxVideoMemory() == null){
            category.setMaxVideoMemory(MAX_VIDEO_MEMORY_IF_ABSENT);
        }
        if(category.getMaxOperativeMemory() == null){
            category.setMaxOperativeMemory(MAX_OPERATIVE_MEMORY_IF_ABSENT);
        }
        return category;
    }
}
