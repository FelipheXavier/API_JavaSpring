package com.restaurante.cardapio.entity;



import com.restaurante.cardapio.dto.FoodDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "foods")
@Entity(name = "food")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private String description;
    private String price;

    public Food(FoodDTO data){
        this.name = data.name();
        this.description = data.description();
        this.photo = data.photo();
        this.price = data.price();
    }
}
