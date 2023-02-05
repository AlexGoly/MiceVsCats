package ua.micehunt.models;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Mouse", description = "Mouse")
public class Mouse {
    private long id;
    private int age;
    private String color;
    private double normalSpeed;
    private double topSpeed;
    private int reproductiveRate;
    private boolean isDead;
}

