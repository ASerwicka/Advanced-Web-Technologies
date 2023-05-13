package com.eatbetter.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "InspirationData")
@Data
public class InspirationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ImagePath")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "TextsID", referencedColumnName = "ID", nullable = false)
    private Texts texts;
}