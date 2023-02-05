package ua.miceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.miceservice.model.Mouse;

public interface MiceRepository extends JpaRepository<Mouse, Long> {
}
