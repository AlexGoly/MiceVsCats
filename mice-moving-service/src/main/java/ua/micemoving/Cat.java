package ua.micemoving;

public class Cat {
    public int length = 2;
    public int direction = 2;

    public int[] catX = new int[300];
    public int[] catY = new int[300];

    public Cat(int x1, int y1, int x2, int y2) {
        catX[0] = x1;
        catX[1] = x2;
        catY[0] = y1;
        catY[1] = y2;

    }
    public void move() {
        for (int i = length; i > 0; i--) {
            catX[i] = catX[i - 1];
            catY[i] = catY[i - 1];

        }
        if (direction == 0) {
            catY[0]--;
        }
        if (direction == 2) {
            catY[0]++;
        }
        if (direction == 1) {
            catX[0]++;
        }
        if (direction == 3) {
            catX[0]--;
        }

        if (catY[0] > MiceAndCatsMovingService.HEIGHT - 1) {
            catY[0] = 0;
        }

        if (catY[0] < 0) {
            catY[0] = MiceAndCatsMovingService.HEIGHT - 1;
        }
        if (catX[0] > MiceAndCatsMovingService.WIDTH - 1) {
            catX[0] = 0;
        }
        if (catX[0] < 0) {
            catX[0] = MiceAndCatsMovingService.WIDTH - 1;
        }
    }
}
