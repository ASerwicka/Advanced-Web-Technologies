package com.eatbetter.Texts;
import com.eatbetter.Texts.TextType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Texts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Texts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Data")
    private String data;

    @ManyToOne
    @JoinColumn(name = "TextTypeID", referencedColumnName = "ID", nullable = false)
    private TextType textType;

}