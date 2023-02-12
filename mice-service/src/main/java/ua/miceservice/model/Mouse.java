package ua.miceservice.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mice")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Mouse", description = "Mouse")
public class Mouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "age", nullable = false)
    private int age;
    private String color;
    private double normalSpeed;
    private double topSpeed;
    private int reproductiveRate;
    private Boolean isDead;
}
