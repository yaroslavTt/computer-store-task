package com.example.app.handler;

import com.example.app.exception.CategoryNotFoundException;
import com.example.app.model.category.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryControllerAdvice {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundCategory(CategoryNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
