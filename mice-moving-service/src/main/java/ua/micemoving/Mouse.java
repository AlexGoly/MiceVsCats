package ua.micemoving;

public class Mouse {
    public  int posX;
    public  int posY;
    public  Mouse(int x, int y){
        this.posX=x;
        this.posY=y;
    }
    public void  setRandomPosition(){
        posX=Math.abs((int) (Math.random()* MiceAndCatsMovingService.WIDTH-1));
        posY=Math.abs((int) (Math.random()* MiceAndCatsMovingService.HEIGHT-1));
    }
}

