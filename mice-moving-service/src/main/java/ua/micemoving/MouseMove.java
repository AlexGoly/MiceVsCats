package ua.micemoving;

import java.awt.*;

import lombok.*;

@AllArgsConstructor
public class MouseMove {
    public Point getMousePosition() {
        int x = (int) (Math.random() * 100);
        int y = (int) (Math.random() * 100);
        Point mouse = new Point(x, y);
return mouse;
    }
}
