package ua.micehunt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micehunt.services.HuntService;
import ua.miceservice.model.Mouse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hunter")
public class HuntController {
    @Autowired
    private HuntService huntService;

    @GetMapping("/mice")
    public ResponseEntity<Optional<List<Mouse>>> searchForMice() {
        Optional<List<Mouse>> mice = huntService.searchForAllMice();
        return ResponseEntity.ok(mice);
    }

    @PostMapping("/mice/mouse/{mouseId}/catch")
    public ResponseEntity<Optional<Mouse>> catchMouse(@PathVariable Long mouseId) {
        Optional<Mouse> catchedMouse = huntService.catchMouse(mouseId);
        return ResponseEntity.ok(catchedMouse);
    }
}
