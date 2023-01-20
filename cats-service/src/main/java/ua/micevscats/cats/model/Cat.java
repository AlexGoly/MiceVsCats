package ua.micevscats.cats.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cat")
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Tag(name="Cat", description="Cat")
public class Cat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", nullable = false)
//    private Cat cat;
    private String name;
    private double age;
    private String color;
    private double normalSpeed;
    private double jumpSpeed;
    private int agility;
    private double eyesight;
}
