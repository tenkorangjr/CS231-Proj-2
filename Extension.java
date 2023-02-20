/*
 * Author: Michael Tenkorang
 * Title: Cosmic Way Of Life
 * Date: 02/19/2023
 * CS 231
 * Section B
 * Extension.java
 */

public class Extension {
    public static void main(String[] args) throws InterruptedException {

        Landscape landscape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                Double.parseDouble(args[2]));
        LandscapeDisplay display = new LandscapeDisplay(landscape, 6);

        for (int count = 0; count <= Integer.parseInt(args[3]); count++) {
            if (display.canvas.listen == 0) {
                break;
            }
            landscape.advance();
            display.repaint();
            Thread.sleep(250);
        }

    }
}
