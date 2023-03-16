package ua.micehunt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.micehunt.models.Cat;
import ua.micehunt.models.Mouse;
import ua.micehunt.services.httpClient.CatsHuntClient;
import ua.micehunt.services.httpClient.MiceHuntClient;

import java.util.List;
import java.util.Optional;

@Service
public class HuntService {
    @Autowired
    MiceHuntClient miceHuntClient;
    @Autowired
    CatsHuntClient catsHuntClient;
    public Optional<List<Mouse>> searchForAllMice() {
        Optional<List<Mouse>> miceListOptional = miceHuntClient.getAllMice();
        return miceListOptional;
    }
    public ResponseEntity<Mouse> findMouseById(Long mouseId) {
        ResponseEntity<Mouse> mice =miceHuntClient.getMice(mouseId) ;
        return mice;
    }

    public  Optional<Mouse> killMouse(Long mouseId,Long killerId) {
        Optional<Mouse> mouse =miceHuntClient.killMouse(mouseId,killerId) ;
        return mouse;
    }
    public Optional<List<Cat>> searchForAllCats() {
        Optional<List<Cat>> allCats= catsHuntClient.getCats();
        return allCats;
    }
    public Optional<Cat> selectCat(Long catId) {
        Optional<Cat> catOptional = catsHuntClient.getCat(catId);
        return catOptional;
    }
    public Optional<List<Mouse>> searchSpottedMice(Long catId) {
        Optional<List<Mouse>>spottedMice = miceHuntClient.getSpottedMice(catId);
        return spottedMice;
    }
    public boolean catchSelectedMouse(Optional<Cat> cat, Mouse selectedMouse) {
        return true;
    }

}
