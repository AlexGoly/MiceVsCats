package ua.miceservice.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.miceservice.model.Mouse;
import ua.miceservice.repository.MiceRepository;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
public class MiceService {
    @Autowired
    MiceRepository miceRepository;

    public Optional<Mouse> getMouseById(Long mouseId) {
        return miceRepository.findById(mouseId);
    }

    public List<Mouse> getAllMice() {

        return miceRepository.findAll();
    }
}
