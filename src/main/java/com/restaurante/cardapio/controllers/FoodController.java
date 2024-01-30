package com.restaurante.cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.cardapio.dto.FoodDTO;
import com.restaurante.cardapio.entity.Food;
import com.restaurante.cardapio.repository.FoodRepository;

@RestController
@RequestMapping("foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodDTO> getAll(){
        List<FoodDTO> foodList = repository.findAll().stream().map(FoodDTO::new).toList();
        return foodList;
    }
    @PostMapping
    public void createFood(@RequestBody FoodDTO data){
        Food food = new Food(data);
        repository.save(food);
        return;
    }
}
