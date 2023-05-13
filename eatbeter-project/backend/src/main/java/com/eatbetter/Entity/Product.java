package com.eatbetter.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {

    public Product(String name, Integer calories, Integer fat, Integer carbohydrates, Integer sugar, Integer protein, Integer salt) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
        this.protein = protein;
        this.salt = salt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Calories", nullable = false)
    private Integer calories;

    @Column(name = "Fat", nullable = false)
    private Integer fat;

    @Column(name = "Carbohydrates", nullable = false)
    private Integer carbohydrates;

    @Column(name = "Sugar", nullable = false)
    private Integer sugar;

    @Column(name = "Protein", nullable = false)
    private Integer protein;

    @Column(name = "Salt", nullable = false)
    private Integer salt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<MealHistory> mealHistories;

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", sugar=" + sugar +
                ", protein=" + protein +
                ", salt=" + salt +
                ", user=" + user.getId();
    }
}
