package ua.cats.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cats.model.Cat;
import ua.cats.repository.CatRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController("endpoint")
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
    public Cat getCat(@  PathVariable Long id) {
        return catRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @Operation(summary = "Create cat")
    public ResponseEntity createCat(@RequestBody Cat cat) throws URISyntaxException {
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
