package com.example.app.controller;

import com.example.app.model.Computer;
import com.example.app.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
public class HomeController {

    private final ComputerRepository computerRepository;

    @GetMapping
    public List<Computer> listAllComputers(){
        return computerRepository.findAll();
    }
}
