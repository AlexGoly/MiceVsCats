package ua.micevscats.cats.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.micevscats.cats.model.Cat;
import ua.micevscats.cats.repository.CatRepository;

import java.util.List;

@RestController
@RequestMapping("/cats")

public class CatController {
    @Autowired
    CatRepository catRepository;

    @GetMapping
    public List<Cat> getCats() {
        return catRepository.findAll();
    }
@GetMapping("/{id}")
    @Operation(summary = "Get cat")
    public Cat getCat(@PathVariable Long id){
        return catRepository.findById(id).orElseThrow(RuntimeException::new);
}

}
