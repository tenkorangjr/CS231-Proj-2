/*
 * Author: Michael Tenkorang
 * Title: Cosmic Way Of Life
 * Date: 02/19/2023
 * CS 231
 * Section B
 * Landscape.java
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        initialChance = chance;
        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        for (int row = 0; row < landscape.length; row++) {
            for (int col = 0; col < landscape[row].length; col++) {
                if (Math.random() < initialChance) {
                    landscape[row][col] = new Cell(true);
                } else {
                    landscape[row][col] = new Cell();
                }
            }
        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String res = "";
        for (int row = 0; row < landscape.length; row++) {
            for (int col = 0; col < landscape[row].length; col++) {
                res += landscape[row][col] + " ";
            }
            res += "\n";
        }
        return res;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> res = new ArrayList<>();
        int rowStart = row - 1;
        int rowEnd = row + 1;
        int colStart = col - 1;
        int colEnd = col + 1;

        if (row == 0) {
            rowStart = row;
        } else if (row == landscape.length - 1) {
            rowEnd = row;
        }

        for (int i = rowStart; i <= rowEnd; i++) {
            if (col == 0) {
                colStart = col;
            } else if (col == landscape[row].length - 1) {
                colEnd = col;
            }
            for (int j = colStart; j <= colEnd; j++) {
                if ((j == col) && (i == row)) {
                    continue;
                }
                res.add(landscape[i][j]);
            }
        }

        return res;
    }

    /**
     * Advances the current Landscape by one step.
     */
    public void advance() {
        Cell[][] temp = new Cell[this.getRows()][this.getCols()];

        for (int row = 0; row < this.landscape.length; row++) {
            for (int col = 0; col < this.landscape[row].length; col++) {
                temp[row][col] = new Cell(this.landscape[row][col].getAlive());
                temp[row][col].updateState(this.getNeighbors(row, col));
            }
        }

        landscape = temp;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
        Landscape myLandscape = new Landscape(10, 12, 0.5);

        System.out.println(myLandscape.getCols());
        System.out.println(myLandscape.getRows());
        System.out.println(myLandscape.getCell(5, 4));
        System.out.println(myLandscape.getNeighbors(9, 11));
        System.out.println(myLandscape);
    }
}
