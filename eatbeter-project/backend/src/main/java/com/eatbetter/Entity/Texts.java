package com.eatbetter.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Texts")
@Data
public class Texts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "Data")
    private String data;

    @ManyToOne
    @JoinColumn(name = "TextTypeID", referencedColumnName = "ID", nullable = false)
    private TextType textType;

    // konstruktory, getters i setters, equals i hashCode

}