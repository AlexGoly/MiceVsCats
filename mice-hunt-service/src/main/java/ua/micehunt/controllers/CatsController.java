package ua.micehunt.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micehunt.models.Cat;
import ua.micehunt.models.Mouse;
import ua.micehunt.services.HuntService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController("endpoint")
@RequestMapping("/api/v1/hunter/cats")
public class CatsController {
    @Autowired
    private HuntService huntService;

    @GetMapping
    @Operation(summary = "Get all cats")
    public ResponseEntity<Optional<List<Cat>>> searchForCats() {
        Optional<List<Cat>> cats = huntService.searchForAllCats();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cat")
    public ResponseEntity<Optional<Cat>> getCat(@PathVariable Long id) {
        Optional<Cat> cat = huntService.selectCat(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @GetMapping("/{catId}/spotted/mice")
    @Operation(summary = "Returns a spotted mice list with coordinates")
    public ResponseEntity<Optional<List<Mouse>>> getMiceSpottedCat(@PathVariable Long catId) {
        Optional<List<Mouse>> spottedMice = huntService.searchSpottedMice(catId);
        return new ResponseEntity<>(spottedMice, HttpStatus.OK);
    }

    @PostMapping("/{catId}/catch-mouse")
    @Operation(summary = "Returns the hunting result." +
            "If the mouse was caught, its state changes to death.\n" +
            "Otherwise, do nothing.")
    public ResponseEntity<Optional<Mouse>> catchMouseAndKill(@PathVariable Long catId,
                                                             @RequestBody Mouse selectedMouse) throws URISyntaxException {
        Long selectedMouseId = selectedMouse.getId();
        Optional<Cat> cat = huntService.selectCat(catId);
        boolean isCatchMouse = huntService.catchSelectedMouse(cat, selectedMouse);
        if (isCatchMouse) {
            Optional<Mouse> deadMouseKiller = huntService.killMouse(selectedMouseId, catId);
            return ResponseEntity.created(new URI("/" + selectedMouseId)).body(deadMouseKiller);
        } else {
            log.info(String.format("The mouse %s was stronger", selectedMouseId));
            return ResponseEntity.ok(Optional.of(selectedMouse));
        }
    }
}
