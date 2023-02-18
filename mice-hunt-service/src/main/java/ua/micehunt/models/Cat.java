package ua.micehunt.models;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Tag(name = "Cat", description = "Cat")
public class Cat {
    private long id;
    private String name;
    private double age;
    private String color;
    private double normalSpeed;
    private double jumpSpeed;
    private int agility;
    private double eyesight;
}
