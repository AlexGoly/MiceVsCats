package ua.cats.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.cats.persistance.entities.Cat;

public interface CatRepository extends JpaRepository<Cat,Long> {
}
