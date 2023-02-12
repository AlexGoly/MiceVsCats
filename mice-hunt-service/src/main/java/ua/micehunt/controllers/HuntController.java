package ua.micehunt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micehunt.models.Mouse;
import ua.micehunt.services.HuntService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hunter")
public class HuntController {
    @Autowired
    private HuntService huntService;

    @GetMapping("/mice")
    public ResponseEntity<Optional<Collection<Mouse>>> searchForMice() {
        Optional<Collection<Mouse>> mice = huntService.searchForAllMice();
        return new ResponseEntity<>(mice, HttpStatus.OK);
    }

    @GetMapping("/mice/mouse/{mouseId}/catch")
    public ResponseEntity<Optional<Mouse>> catchMouse(@PathVariable Long mouseId) {
        Optional<Mouse> cachedMouse = huntService.catchMouse(mouseId);
        return new ResponseEntity<>(cachedMouse, HttpStatus.OK);
    }

    @PutMapping("/mice/mouse/{mouseId}/kill")
    public ResponseEntity<Optional<Mouse>> killMouse(@PathVariable Long mouseId) {
        Optional<Mouse> deadMouse = huntService.killMouse(mouseId);
        return new ResponseEntity<>(deadMouse, HttpStatus.OK);
    }

}
