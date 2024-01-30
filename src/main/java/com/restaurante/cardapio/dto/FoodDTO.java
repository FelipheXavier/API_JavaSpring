package com.restaurante.cardapio.dto;

import com.restaurante.cardapio.entity.Food;

public record FoodDTO(Long id,String name,String description,double price) {
    public FoodDTO(Food food){
        this(food.getId(),food.getName(),food.getDescription(),food.getPrice());
    }
}