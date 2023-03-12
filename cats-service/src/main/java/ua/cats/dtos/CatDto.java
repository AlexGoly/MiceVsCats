package ua.cats.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
// ToDo: Add descriptions to all fields
public class CatDto {
    @Schema(example = "777")
    private Long id;

    @Schema(description = "Beautiful cat name", example = "Leopold")
    private String name;

    @Schema(description = "Age of the cat in years", example = "2.5")
    private Double age;
    private String color;
    private Double normalSpeed;
    private Double jumpSpeed;
    private Integer agility;
    private Double eyesight;

}
