package com.example.app.controller;

import com.example.app.model.computers.Computer;
import com.example.app.repository.ComputerRepository;
import com.example.app.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
public class HomeController {

    private final ComputerService computerService;

    @GetMapping
    public List<Computer> listAllComputers(){
        return computerService.getAllComputers();
    }

    @GetMapping("/categories/{categoryName}")
    public List<Computer> listComputersByCategory(@PathVariable("categoryName")String categoryName){
        return computerService.getComputersByCategoryName(categoryName);
    }
}
