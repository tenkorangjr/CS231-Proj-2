import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        if (this.alive) {
            if (!((getTotal(neighbors) == 2) || (getTotal(neighbors) == 3))) {
                this.setAlive(false);
            }
        } else {
            if (getTotal(neighbors) == 3) {
                this.setAlive(true);
            }
        }
    }

    private static int getTotal(ArrayList<Cell> arr) {
        int total = 0;
        for (Cell cell : arr) {
            if (cell.getAlive()) {
                total += 1;
            }
        }

        return total;
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (alive) {
            return "1";
        } else {
            return "0";
        }
    }

    public static void main(String[] args) {
        Cell cell1 = new Cell();
        Cell cell2 = new Cell(true);

        System.out.println(cell1);
        System.out.println(cell2.getAlive());

        cell1.setAlive(true);
        System.out.println(cell1);
    }
}