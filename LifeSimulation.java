/*
 * Author: Michael Tenkorang
 * Title: Cosmic Way Of Life
 * Date: 02/19/2023
 * CS 231
 * Section B
 * LifeSimulation.java
 */

public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {

        /*
         * Create GUI for the Cosmic Way Of Life
         */

        Landscape landscape = new Landscape(50, 50, 0.25);
        LandscapeDisplay display = new LandscapeDisplay(landscape, 6);

        for (int count = 0; count <= 10000; count++) {
            if (display.canvas.listen == 0) {
                break;
            }
            landscape.advance();
            display.repaint();
            Thread.sleep(250);
        }

    }
}
