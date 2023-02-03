package com.example.app.dto;

import com.example.app.model.computers.Computer;
import lombok.Data;

@Data
public class OrderProductDto {
    private Computer product;
    private Integer quantity;
}
