package ru.job4j.thread;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int flag = 0;
        while (true) {
            if (this.rect.getX() < 300 && flag != -1) {
                this.rect.setX(this.rect.getX() + 25);
                if (this.rect.getX() == 300) {
                    flag = -1;
                }
            } else if (flag == -1) {
                this.rect.setX(this.rect.getX() - 25);
                if (this.rect.getX() == 0) {
                    flag = 1;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}