package ua.micehunt.services.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.micehunt.models.Cat;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "catsHuntClient", url = "http://localhost:8091/")

public interface CatsHuntClient {
    @GetMapping(value = "/cats")
    Optional<List<Cat>> getCats();
    @GetMapping(value = "/cats/{catId}")
    Optional <Cat> getCat(@PathVariable(name = "catId") Long catId);
}
