/*
 * Author: Michael Tenkorang
 * Title: Cosmic Way Of Life
 * Date: 02/19/2023
 * CS 231
 * Section B
 * LandscapeDisplay.java
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a Landscape graphically using Swing. The Landscape
 * contains a grid which can be displayed at any scale factor.
 * 
 * @author bseastwo
 */
public class LandscapeDisplay {
    JFrame win;
    protected Landscape scape;
    public LandscapePanel canvas;
    private int gridScale; // width (and height) of each square in the grid

    /**
     * Initializes a display window for a Landscape.
     * 
     * @param scape the Landscape to display
     * @param scale controls the relative size of the display
     */
    public LandscapeDisplay(Landscape scape, int scale) {
        // setup the window
        this.win = new JFrame("Game of Life");

        this.win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.scape = scape;
        this.gridScale = scale;

        // create a panel in which to display the Landscape
        // put a buffer of two rows around the display grid
        this.canvas = new LandscapePanel((int) (this.scape.getCols() + 4) * this.gridScale,
                (int) (this.scape.getRows() + 4) * this.gridScale);

        // add the panel to the window, layout, and display
        this.win.add(this.canvas, BorderLayout.CENTER);
        this.win.pack();
        this.win.setVisible(true);

    }

    /**
     * Saves an image of the display contents to a file. The supplied
     * filename should have an extension supported by javax.imageio, e.g.
     * "png" or "jpg".
     *
     * @param filename the name of the file to save
     */
    public void saveImage(String filename) {
        // get the file extension from the filename
        String ext = filename.substring(filename.lastIndexOf('.') + 1, filename.length());

        // create an image buffer to save this component
        Component tosave = this.win.getRootPane();
        BufferedImage image = new BufferedImage(tosave.getWidth(), tosave.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // paint the component to the image buffer
        Graphics g = image.createGraphics();
        tosave.paint(g);
        g.dispose();

        // save the image
        try {
            ImageIO.write(image, ext, new File(filename));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * This inner class provides the panel on which Landscape elements
     * are drawn.
     */
    public class LandscapePanel extends JPanel implements ActionListener {
        /**
         * Creates the panel.
         * 
         * @param width  the width of the panel in pixels
         * @param height the height of the panel in pixels
         */
        public JButton btn;
        int listen = 1;

        public LandscapePanel(int width, int height) {
            super();
            this.btn = new JButton("Stop");
            this.setPreferredSize(new Dimension(width, height));
            this.setBackground(Color.lightGray);
            this.add(btn);

            btn.addActionListener(this);
        }

        /**
         * Method overridden from JComponent that is responsible for
         * drawing components on the screen. The supplied Graphics
         * object is used to draw.
         * 
         * @param g the Graphics object used for drawing
         */
        public void paintComponent(Graphics g) {
            // take care of housekeeping by calling parent paintComponent
            super.paintComponent(g);

            // call the Landscape draw method here
            scape.draw(g, gridScale);
        } // end paintComponent

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source.equals(this.btn)) {
                listen = 0;
                this.btn.setName("Stopped");
            }
        }

    } // end LandscapePanel

    public void repaint() {
        // Repaint the Display
        this.win.repaint();
    }

    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(100, 100, .25);

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        // Uncomment below when advance() has been finished
        while (true) {
            Thread.sleep(10);
            scape.advance();
            display.repaint();
        }
    }
}