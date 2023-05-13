package com.eatbetter.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "DietGoal")
@Data
public class DietGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Calories")
    private Integer calories;

    @Column(name = "Fat")
    private Integer fat;

    @Column(name = "Carbohydrates")
    private Integer carbohydrates;

    @Column(name = "Sugar")
    private Integer sugar;

    @Column(name = "Protein")
    private Integer protein;

    @Column(name = "Salt")
    private Integer salt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DieteticianID", nullable = false)
    private User dietetician;

    @OneToMany(mappedBy = "dietGoal")
    private List<User> users;


}