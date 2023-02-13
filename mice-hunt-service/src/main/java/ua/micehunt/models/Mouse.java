package ua.micehunt.models;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Mouse", description = "Mouse")
public class Mouse {
    private Long id;
    private Integer age;
    private String color;
    private Double normalSpeed;
    private Double topSpeed;
    private Integer reproductiveRate;
    private Boolean isDead;
    @Column(name = "killer_id")
    private Long killerId;
}

