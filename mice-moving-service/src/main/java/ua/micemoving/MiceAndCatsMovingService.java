package ua.micemoving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;

public class MiceAndCatsMovingService extends JPanel implements ActionListener {
    public static void main(String[] args) {

        jFrame = new JFrame("MiceVsCats");
        jFrame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 30);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new MiceAndCatsMovingService());
        jFrame.setVisible(true);

    }

    public static JFrame jFrame;
    public static final int SCALE = 32; // размер клетки
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 3;
    Timer timer = new Timer(1000 / speed, this);

    Cat cat = new Cat(5, 6, 5, 5);
    Mouse mouse = new Mouse(
            Math.abs((int) (Math.random() * MiceAndCatsMovingService.WIDTH - 1)),
            Math.abs((int) (Math.random() * MiceAndCatsMovingService.HEIGHT - 1))
    );

    public MiceAndCatsMovingService() {
        timer.start();
//        addKeyListener(new KeyBoard());
        new KeyBoard();
        setFocusable(true);

    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        for (int x = 0; x < HEIGHT * SCALE; x = x + SCALE) {
            graphics.setColor(Color.BLACK);
            graphics.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y = y + SCALE) {
            graphics.setColor(Color.BLACK);
            graphics.drawLine(0, y, WIDTH * SCALE, y);
        }
        for (int i = 0; i < cat.length; i++) {
            graphics.setColor(Color.GREEN);
            graphics.fillRect(cat.catX[i] * SCALE + 1, cat.catY[i] * SCALE - 3, SCALE - 3, SCALE - 1);
        }
        graphics.setColor(Color.GRAY);
        graphics.fillRect(cat.catX[0] * SCALE + 3, cat.catY[0] * SCALE + 1, SCALE - 3, SCALE - 3);
        graphics.setColor(Color.RED);
        graphics.fillOval(mouse.posX * SCALE + 4, mouse.posY * SCALE + 4, SCALE - 8, SCALE - 8);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cat.move();
        repaint();
        if (cat.catX[0] == mouse.posX && cat.catY[0] == mouse.posY) {
            mouse.setRandomPosition();
            cat.length++;
        }
        for (int i = 1; i < cat.length; i++) {
            if (cat.catX[i] == mouse.posX && cat.catY[i] == mouse.posY) {
                mouse.setRandomPosition();
            }

            if (cat.catX[0] == cat.catX[i] && cat.catY[0] == cat.catY[i]) {
                timer.stop();
                JOptionPane.showMessageDialog(null, "Вы проиграли,начать заново");
                jFrame.setVisible(false);
                cat.length = 2;
                cat.direction = 0;
                mouse.setRandomPosition();
                jFrame.setVisible(true);
                timer.start();

            }
        }

    }

    //    public class KeyBoard extends KeyAdapter {
    public class KeyBoard {
        //        public void keyPressed(KeyEvent event) {
        public  int timeNow = LocalTime.now().getSecond();
//            if((timeNow%2!=0)==false)
        {
            cat.direction = (int) ((Math.random()) * (4 - 0) + 0);
        }
    }
//            int key = event.getKeyCode();


//            if (key == KeyEvent.VK_UP && cat.direction != 2) {
//                cat.direction = 0;
//            }
//            if (key == KeyEvent.VK_DOWN && cat.direction != 0) {
//                cat.direction = 2;
//            }
//            if (key == KeyEvent.VK_LEFT && cat.direction != 1) {
//                cat.direction = 3;
//            }
//            if (key == KeyEvent.VK_RIGHT && cat.direction != 3) {
//                cat.direction = 1;
//            }
}


