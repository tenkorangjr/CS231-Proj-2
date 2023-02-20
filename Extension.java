public class Extension {
    public static void main(String[] args) throws InterruptedException {

        Landscape landscape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                Double.parseDouble(args[2]));
        LandscapeDisplay display = new LandscapeDisplay(landscape, 6);

        for (int count = 0; count <= Integer.parseInt(args[3]); count++) {
            landscape.advance();
            display.repaint();
            Thread.sleep(250);
        }

    }
}
