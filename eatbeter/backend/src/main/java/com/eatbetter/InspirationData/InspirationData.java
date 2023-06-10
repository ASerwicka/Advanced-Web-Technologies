package com.eatbetter.InspirationData;
import com.eatbetter.Texts.Texts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "InspirationData")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
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