package ua.cats.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cats.persistance.entities.Cat;
import ua.cats.persistance.repositories.CatRepository;

import java.util.List;

@Service
public class CatService {

    @Autowired
    CatRepository catRepository;

    public List<Cat> getAllCats() {

        return catRepository.findAll();

    }

}
