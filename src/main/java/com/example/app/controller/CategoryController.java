package com.example.app.controller;

import com.example.app.model.category.Category;
import com.example.app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);

        return ResponseEntity.ok("Category created");
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<Object> updateCategory(@PathVariable("categoryId")Long categoryId, @RequestBody Category category){
        categoryService.updateCategory(categoryId, category);
        return ResponseEntity
                .ok()
                .body("Category updated");
    }

    @GetMapping("")
    public ResponseEntity<Object> listCategories(){
        return ResponseEntity
                .ok()
                .body(categoryService.getAllCategories());
    }

}
