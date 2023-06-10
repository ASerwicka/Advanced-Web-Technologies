package com.eatbetter.User;

import com.eatbetter.DietGoal.DietGoal;
import com.eatbetter.Meal.MealHistory;
import com.eatbetter.Product.Product;
import com.eatbetter.Login.Role;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"User\"")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name",unique = true, length = 255)
    private String name;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "Password", length = 255)
    private String password;

    @Column(name = "Oauth2Id",unique = true, length = 255)
    private String oauth2Id;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DietGoalID")
    @ToString.Exclude
    private DietGoal dietGoal;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleID")
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<MealHistory> mealHistories;
    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Product> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
