package ua.micemoving.services.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ua.micemoving.model.Mouse;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "miceClient", url = "http://localhost:8093/")
public interface MiceClient {
    @GetMapping(value = "/mice")
    Optional<List<Mouse>>getAllMice();
    @GetMapping(value = "/mice/{mouseId}")
    Optional<Mouse>getMouse(@PathVariable(name = "mouseId") Long mouseId);
    @PutMapping(value = "/mice/{mouseId}/kill/killer/{killerId}")
    Optional<Mouse> killMouse(@PathVariable(name = "mouseId") Long mouseId,
                              @PathVariable(name = "killerId") Long killerId);
}
