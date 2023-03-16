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
    private Long id;
    private String name;
    private Double age;
    private String color;
    private Double normalSpeed;
    private Double jumpSpeed;
    private Integer agility;
    private Double eyesight;
}
