package ua.micevscats.cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.micevscats.cats.model.Cat;

public interface CatRepository extends JpaRepository<Cat,Long> {
}
