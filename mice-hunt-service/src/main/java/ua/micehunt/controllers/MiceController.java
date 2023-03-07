package ua.micehunt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micehunt.models.Mouse;
import ua.micehunt.services.HuntService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/hunter")
@RequiredArgsConstructor
public class MiceController {
    @Autowired
    private HuntService huntService;

    @GetMapping("/mice")
    public ResponseEntity<Optional<List<Mouse>>> searchForMice() {
        Optional<List<Mouse>> mice = huntService.searchForAllMice();
        return new ResponseEntity<>(mice, HttpStatus.OK);
    }

    @PutMapping("/mice/mouse/{mouseId}/kill/killer/{killerId}")
    public ResponseEntity<Optional<Mouse>> killMouse(@PathVariable Long mouseId,@PathVariable Long killerId) {
        Optional<Mouse> deadMouse = huntService.killMouse(mouseId,killerId);
        return new ResponseEntity<>(deadMouse, HttpStatus.OK);
    }
}
