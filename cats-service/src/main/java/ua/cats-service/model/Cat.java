package ua.micevscats.cats.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cat")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Cat", description = "Cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private double age;
    private String color;
    private double normalSpeed;
    private double jumpSpeed;
    private int agility;
    private double eyesight;

}
