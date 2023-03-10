package ua.cats.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cats.persistance.entities.Cat;
import ua.cats.persistance.repositories.CatRepository;
import ua.cats.services.CatService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1/cats")
public class CatController {

    @Autowired
    CatRepository catRepository;

    @Autowired
    CatService catService;

    @GetMapping
    @Operation(summary = "Get a list of all cats")
    public ResponseEntity< List<Cat>> getCats() {

        return catService.getAllCats();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cat")
    public Cat getCat(@PathVariable Long id) {

        return catRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

    }

    @PostMapping
    @Operation(summary = "Create cat")
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) throws URISyntaxException {
        Cat savedCat = catRepository.save(cat);
        return ResponseEntity.created(new URI("/cats/" + savedCat.getId())).body(savedCat);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Rename cat", description = "Update cat name")
    public ResponseEntity updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        //ToDo; Customise exception
        Cat currentCat = catRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCat.setName(cat.getName());
        currentCat = catRepository.save(cat);
        return ResponseEntity.ok(currentCat);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete cat")
    public ResponseEntity deleteCat(@PathVariable Long id) {
        catRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
