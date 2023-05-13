package com.eatbetter.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TextType")
@Data
public class TextType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    // konstruktory, getters i setters, equals i hashCode

}
