package com.example.spring_boot.model;

public record DTO (
        Long id,
        String phoneBrand,
        String phoneModel,
        String color,
        double price,
        int storage
) {
}
