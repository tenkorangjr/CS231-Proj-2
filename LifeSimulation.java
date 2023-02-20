public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {

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
