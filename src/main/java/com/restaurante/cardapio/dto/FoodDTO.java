package com.restaurante.cardapio.dto;

import com.restaurante.cardapio.entity.Food;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodDTO(Long id, 
@NotBlank @NotNull
String name,
String description,
String photo,
double price) {
    public FoodDTO(Food food){
        this(food.getId(),food.getName(),food.getDescription(),food.getPhoto(),food.getPrice());
    }
}
