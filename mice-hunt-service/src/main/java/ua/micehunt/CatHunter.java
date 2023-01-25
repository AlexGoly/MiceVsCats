package ua.micehunt;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatHunter {

    public   boolean isMouseDetected() {
        double roomSquare = Math.random();
        int sumMiceInRoom = (int) (Math.random() * 100);
        //ToDO: Make real dependency
        double catEyesight =Math.random();
        boolean isCatch =(roomSquare / sumMiceInRoom) < catEyesight;
        System.out.println(isCatch);
        System.out.println("******************************************");
        return isCatch;
    }
    private boolean isMouseCatch(){
        return false;
    }
}
