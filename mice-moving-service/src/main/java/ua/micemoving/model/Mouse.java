package ua.micemoving.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Tag(name = "Mouse", description = "Mouse")
public class Mouse {
    private Long id;
    private Integer age;
    private String color;
    private Double normalSpeed;
    private Double topSpeed;
    private Integer reproductiveRate;
    private Boolean isDead;
    private Long killerId;
    private Integer latitude;
    private Integer longitude;
}

