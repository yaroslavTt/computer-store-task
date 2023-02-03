package com.example.app.controller;


import com.example.app.model.computers.Computer;
import com.example.app.repository.ComputerRepository;
import com.example.app.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CompositeIterator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
@RequiredArgsConstructor
public class ComputerController {
    private final ComputerService computerService;

    @GetMapping("/all")
    public ResponseEntity<Object> listAllComputers(){
        return ResponseEntity.ok(computerService.getAllComputers());
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<Object> listComputersByCategory(@PathVariable("categoryName")String categoryName){
        return ResponseEntity.ok(computerService.getComputersByCategoryName(categoryName));
    }

    @PostMapping
    public ResponseEntity<Object> createNewComputer(@RequestBody Computer computer){
        computerService.saveComputer(computer);
        return ResponseEntity.ok("Computer saved");
    }
}
