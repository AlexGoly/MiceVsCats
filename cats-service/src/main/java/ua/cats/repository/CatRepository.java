package ua.cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.cats.model.Cat;

public interface CatRepository extends JpaRepository<Cat,Long> {
}
