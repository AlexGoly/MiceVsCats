package ua.micemoving.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micemoving.model.Mouse;
import ua.micemoving.services.MiceMoveService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/move")
public class MiceController {
    @Autowired
    private MiceMoveService miceMoveService;

    @GetMapping("/mice")
    public ResponseEntity<Optional<Collection<Mouse>>> searchForMice() {
        Optional<Collection<Mouse>> mice = miceMoveService.searchForAllMice();
        return new ResponseEntity<>(mice, HttpStatus.OK);
    }

    @GetMapping("/mice/mouse/{mouseId}/catch")
    public ResponseEntity<Optional<Mouse>> catchMouse(@PathVariable Long mouseId) {
        Optional<Mouse> cachedMouse = miceMoveService.catchMouse(mouseId);
        return new ResponseEntity<>(cachedMouse, HttpStatus.OK);
    }

    @PutMapping("/mice/mouse/{mouseId}/kill")
    public ResponseEntity<Optional<Mouse>> killMouse(@PathVariable Long mouseId) {
        Optional<Mouse> deadMouse = miceMoveService.killMouse(mouseId);
        return new ResponseEntity<>(deadMouse, HttpStatus.OK);
    }

    @GetMapping("/cats/{catId}/spotted/mice")
    public ResponseEntity<Optional<Collection<Mouse>>> spottedMice(@PathVariable Long catId) {
        Optional<Collection<Mouse>> allMice = miceMoveService.searchForAllMice();
        Optional<Collection<Mouse>> spottedMice = miceMoveService.spottedMice(allMice);
        return new ResponseEntity<>(spottedMice, HttpStatus.OK);
    }

    @PostMapping("/mice/mouse/{mouseId}/killer/{killerId}")
    public ResponseEntity<Optional<Mouse>> setMouseKiller(@PathVariable Long mouseId,
                                                          @PathVariable Long killerId) {
        Optional<Mouse> deadMouse = miceMoveService.setMouseKiller(mouseId, killerId);
        return new ResponseEntity<>(deadMouse, HttpStatus.OK);
    }
}
