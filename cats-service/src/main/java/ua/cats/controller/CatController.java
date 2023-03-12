package ua.cats.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.cats.dtos.CatDto;
import ua.cats.persistance.entities.Cat;
import ua.cats.persistance.repositories.CatRepository;
import ua.cats.services.CatService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/v1/cats")
// ToDo: Add OpenAPI documentation
// ToDo: Implement exception handling via Controller Advice
public class CatController {

    @Autowired
    // ToDo: Only service should operate with JPA repository(-ies)
    CatRepository catRepository;

    @Autowired
    CatService catService;


    @GetMapping
    @Operation(
            summary = "Get cats",
            description = "Gets a list of all cats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Received a list of cats")
    })
    public List<CatDto> getCats() {

        return
                catService.getAllCats();

    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the cat",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cat not found",
                    content = @Content)})
    @GetMapping("/{id}")
    @Operation(
            summary = "Get cat",
            description = "Gets a cat by it's ID ")
    // ToDo: PathVariable OpenAPI description
    public CatDto returnCat(@PathVariable Long id) {

        return
                catService.getCat(id);

    }


    @PostMapping
    @Operation(summary = "Create cat")
    // ToDo: Request body validation
    // ToDo: OpenAPI description
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) throws URISyntaxException {
        Cat savedCat = catRepository.save(cat);
        return ResponseEntity.created(new URI("/cats/" + savedCat.getId())).body(savedCat);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Rename cat", description = "Update cat name")
    // ToDo: Request body validation
    // ToDo: OpenAPI description
    public ResponseEntity updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        //ToDo; Customise exception
        Cat currentCat = catRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCat.setName(cat.getName());
        currentCat = catRepository.save(cat);
        return ResponseEntity.ok(currentCat);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete cat")
    // ToDo: OpenAPI description
    public ResponseEntity deleteCat(@PathVariable Long id) {
        catRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
