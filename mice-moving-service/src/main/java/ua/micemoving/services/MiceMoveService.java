package ua.micemoving.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.micemoving.model.Mouse;
import ua.micemoving.services.httpClient.MiceClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MiceMoveService {
    @Autowired
    MiceLocation miceLocation;
    @Autowired
    MiceClient miceClient;

    public   Optional<List<Mouse>> searchForAllMice() {
        Optional<List<Mouse>>mouseListOptional = miceClient.getAllMice();
        return mouseListOptional;
    }

    public Optional<Mouse> catchMouse(Long mouseId) {
        Optional<Mouse> mouseListOptional = miceClient.getMouse(mouseId);
        return mouseListOptional;
    }

    public Optional<Mouse> killMouse(Long mouseId,Long killerId) {
        Optional<Mouse> mouseOptional = miceClient.killMouse(mouseId,killerId);
        return mouseOptional;
    }

    public Optional<List<Mouse>> spottedMice(Optional<List<Mouse>> mice) {
        //ToDo: Make method for get cat position
        int catLatitude = 50;
        int catLongitude = 50;
        List<Mouse> miceSetPositions = mice.get().stream().toList();
        for (Mouse mouse : miceSetPositions) {
            mouse.setLatitude(miceLocation.getMousePosition().x);
            mouse.setLongitude(miceLocation.getMousePosition().y);
        }
        List<Mouse> aliveMice = miceSetPositions.stream().filter(mice1 -> !mice1.getIsDead()).toList();
        List<Mouse> spottedMice = new ArrayList<>();
        for (Mouse mouse : aliveMice) {
            if (mouse.getLatitude() <= catLatitude + 20 && mouse.getLatitude() >= catLatitude - 20
                    || mouse.getLongitude() <= catLongitude + 20 && mouse.getLongitude() >= catLongitude - 20) {
                spottedMice.add(mouse);
            }
        }
        Optional<List<Mouse>>spottedMiceOptional = Optional.of(spottedMice);
        return spottedMiceOptional;
    }
}
