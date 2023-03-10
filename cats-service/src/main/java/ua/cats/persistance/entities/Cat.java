package ua.cats.persistance.entities;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cat")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Tag(name = "Cat", description = "Cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private Double age;
    private String color;
    private Double normalSpeed;
    private Double jumpSpeed;
    private Integer agility;
    private Double eyesight;

}
