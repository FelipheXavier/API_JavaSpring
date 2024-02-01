package com.restaurante.cardapio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.cardapio.dto.FoodDTO;
import com.restaurante.cardapio.entity.Food;
import com.restaurante.cardapio.exception.NotFound;
import com.restaurante.cardapio.repository.FoodRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("foods")
public class FoodController {
    
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodDTO>> getAll(){
        var foodList = repository.findAll().stream().map(FoodDTO::new).toList();
        return ResponseEntity.ok(foodList);
    }


    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<FoodDTO> getById(@PathVariable Long id){
        var food =  repository.findById(id).orElseThrow(()->new NotFound("id is invalid"));
        return ResponseEntity.ok(new FoodDTO(food));

    }
    
    
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Void> createFood(@RequestBody FoodDTO data){
        Food food = new Food(data);
        repository.save(food);
        return ResponseEntity.noContent().build();
    }


    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<FoodDTO> updateFood(@PathVariable Long id,@RequestBody @Valid FoodDTO data){
        Food food = repository.findById(id).orElseThrow(()->new NotFound("id is invalid"));
        food.setName(data.name());
        food.setDescription(data.description());
        food.setPhoto(data.photo());
        food.setPrice(data.price());
        Food uptadedNewFood = repository.save(food);
        return ResponseEntity.ok(new FoodDTO(uptadedNewFood)); 
    }



    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllFoods(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
