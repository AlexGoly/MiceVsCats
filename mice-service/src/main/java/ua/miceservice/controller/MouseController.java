package ua.miceservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.miceservice.model.Mouse;
import ua.miceservice.repository.MiceRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController("endpoint")
@RequestMapping("/mice")
public class MouseController {
    @Autowired
    MiceRepository miceRepository;

    @GetMapping
    public List<Mouse> getAllMice() {
        return miceRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mouse")
    public Mouse getMouse(@PathVariable Long id) {
        return miceRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @PostMapping
    @Operation(summary = "Create mouse")
    public ResponseEntity createMouse(@RequestBody Mouse mouse) throws URISyntaxException {
        Mouse savedMouse = miceRepository.save(mouse);
        return ResponseEntity.created(new URI("/mice/" + savedMouse.getId())).body(savedMouse);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete mouse")
    public ResponseEntity deleteMouse(@PathVariable Long id) {
        miceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
