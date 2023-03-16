package ua.cats.services;

import ua.cats.dtos.CatDto;

import java.util.List;

public interface CatService {

    CatDto getCat(Long id);

    List<CatDto> getAllCats();

}
