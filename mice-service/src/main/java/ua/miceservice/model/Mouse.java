package ua.miceservice.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "Mouse", description = "Mouse")
public class Mouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "age", nullable = false)
    private Integer age;
    private String color;
    private Double normalSpeed;
    private Double topSpeed;
    private Integer reproductiveRate;
    private Boolean isDead;
    @Column(name = "killer_id")
    private Long killerId;
    //ToDo: What type is usable in Entity primitive or  object wrapper
}
