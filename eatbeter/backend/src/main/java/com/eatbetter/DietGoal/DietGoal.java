package com.eatbetter.DietGoal;
import com.eatbetter.User.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DietGoal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DieteticianID", nullable = false)
    private User dietetician;

    @OneToOne(mappedBy = "dietGoal")
    private User user;

    @Override
    public String toString() {
        return "{" +
                "calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", sugar=" + sugar +
                ", protein=" + protein +
                ", salt=" + salt +
                ", dieteticianId=" + dietetician.getId() +
                '}';
    }
}