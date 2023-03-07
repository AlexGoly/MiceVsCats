package ua.micehunt.services.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ua.micehunt.models.Mouse;

import java.util.List;
import java.util.Optional;


@FeignClient(value = "miceHuntClient", url = "http://localhost:8094/api/v1/move/")
public interface MiceHuntClient {
    @GetMapping(value = "/mice")
    public Optional<List<Mouse>> getAllMice();
    @GetMapping(value = "/mice/mouse/{mouseId}/catch")
    public ResponseEntity<Mouse> getMice(@PathVariable(name = "mouseId") Long mouseId);

    @PutMapping(value = "/mice/mouse/{mouseId}/kill/killer/{killerId}")
    Optional<Mouse> killMouse(@PathVariable(name = "mouseId") Long mouseId, @PathVariable(name = "killerId") Long killerId);
    @GetMapping(value = "/cats/{catId}/spotted/mice")
    Optional<List<Mouse>> getSpottedMice(@PathVariable(name = "catId") Long catId);

}

