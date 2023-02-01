package com.example.app.controller;

import com.example.app.model.computers.Computer;
import com.example.app.model.computers.Laptop;
import com.example.app.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
public class HomeController {

    private final LaptopRepository laptopRepository;

    @GetMapping
    public List<Laptop> listAllComputers(){
        return laptopRepository.findAll();
    }
}
