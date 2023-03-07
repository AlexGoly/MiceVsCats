package ua.micemoving.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.micemoving.model.Mouse;
import ua.micemoving.services.MiceMoveService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/move")
public class MiceController {
    @Autowired
    private MiceMoveService miceMoveService;
    @GetMapping("/mice")
    public ResponseEntity<Optional<List<Mouse>>> searchForMice() {
        Optional<List<Mouse>> mice = miceMoveService.searchForAllMice();
        return new ResponseEntity<>(mice, HttpStatus.OK);
    }
    @GetMapping("/mice/mouse/{mouseId}/catch")
    public ResponseEntity<Optional<Mouse>> catchMouse(@PathVariable Long mouseId) {
        Optional<Mouse> cachedMouse = miceMoveService.catchMouse(mouseId);
        return new ResponseEntity<>(cachedMouse, HttpStatus.OK);
    }
    @PutMapping("/mice/mouse/{mouseId}/kill/killer/{killerId}")
    public ResponseEntity<Optional<Mouse>> killMouse(@PathVariable Long mouseId,@PathVariable Long killerId) {
        Optional<Mouse> deadMouse = miceMoveService.killMouse(mouseId,killerId);
        return new ResponseEntity<>(deadMouse, HttpStatus.OK);
    }
    @GetMapping("/cats/{catId}/spotted/mice")
    public ResponseEntity<Optional<List<Mouse>>> spottedMice(@PathVariable Long catId) {
        Optional<List<Mouse>>allMice = miceMoveService.searchForAllMice();
        Optional<List<Mouse>>spottedMice = miceMoveService.spottedMice(allMice);
        return new ResponseEntity<>(spottedMice, HttpStatus.OK);
    }
}
