package ua.micevscats.cats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cat")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cat {
    @Id
    @GeneratedValue
    private long id;
    private  String name;
    private  String age;
    private  String color;
    private  String  normalSpeed;
    private  String  jumpSpeed;
    private  String  agility;
    private  String  eyesight;
}
