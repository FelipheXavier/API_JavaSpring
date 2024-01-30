package com.restaurante.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.cardapio.entity.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{
    
}
