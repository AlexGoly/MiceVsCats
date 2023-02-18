package ua.micemoving.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Random;

import static ua.micemoving.services.Constants.ROOM_SIZE_MAX;
import static ua.micemoving.services.Constants.ROOM_SIZE_MIN;


@AllArgsConstructor
@Service
public class MiceLocation {
    public Point getMousePosition() {
        Random random = new Random();
        int latitude = random.nextInt(ROOM_SIZE_MAX - ROOM_SIZE_MIN) + ROOM_SIZE_MIN;
        int longitude = random.nextInt(ROOM_SIZE_MAX - ROOM_SIZE_MIN) + ROOM_SIZE_MIN;
        Point mousePosition = new Point(latitude, longitude);
        return mousePosition;
    }
}
