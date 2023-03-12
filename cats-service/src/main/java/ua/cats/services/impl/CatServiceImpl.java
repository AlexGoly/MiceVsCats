package ua.cats.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cats.dtos.CatDto;
import ua.cats.mappers.CatMapper;
import ua.cats.persistance.entities.Cat;
import ua.cats.persistance.repositories.CatRepository;
import ua.cats.services.CatService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    CatRepository catRepository;
    @Autowired
    CatMapper mapper;

    @Override
    public CatDto getCat(Long id) {

        Cat cat = catRepository
                .findById(id)
                // ToDo: Handle better!!!
                .orElseThrow(RuntimeException::new);

        return mapper.toDto(cat);

    }

    @Override
    public List<CatDto> getAllCats() {

        List<Cat> cats = catRepository.findAll();

        return cats.stream()
                .map((Cat cat) ->
                        mapper.toDto(cat)
                )
                .collect(Collectors.toList());

    }

}
