/*
 * Author: Michael Tenkorang
 * Title: Cosmic Way Of Life
 * Date: 02/19/2023
 * CS 231
 * Section B
 * LandscapeTests.java
 */

import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {

            // set up
            Landscape l1 = new Landscape(6, 3, 0.25);

            // verify
            System.out.println(l1);

            // test
            l1.reset();
            for (int i = 0; i < l1.getRows(); i++) {
                for (int j = 0; j < l1.getCols(); j++) {
                    Cell c = l1.getCell(i, j);
                    assert c.getAlive() || !c.getAlive() : "Error in Landscape::reset()";
                }
            }

        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l1 = new Landscape(6, 3, 0.35);

            // verify
            System.out.println(l1.getRows());

            // test
            assert l1.getRows() == 4 : "Error in Landscape::getRows()";
        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l1 = new Landscape(5, 6);

            // verify
            System.out.println(l1.getCols());

            // test
            assert l1.getCols() == 6 : "Error in Landscape::Landscape(int, int)";

        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);

            // verify
            System.out.println(l1.getCell(0, 0));

            // test
            for (int i = 0; i < l1.getRows(); i++) {
                for (int j = 0; j < l1.getCols(); j++) {
                    Cell c = l1.getCell(i, j);
                    assert c != null : "Error in Landscape::getCell(int, int)";
                }
            }
        }

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l1 = new Landscape(7, 8);

            // verify
            System.out.println(l1.getNeighbors(2, 3));

            // test
            ArrayList<Cell> neighbors = l1.getNeighbors(0, 0);
            assert neighbors.size() == 3 : "Error in Landscape::Landscape(int, int)";
            ArrayList<Cell> neighbors2 = l1.getNeighbors(0, 2);
            assert neighbors2.size() == 3 : "Error in Landscape::Landscape(int, int)";
            ArrayList<Cell> neighbors3 = l1.getNeighbors(6, 2);
            assert neighbors3.size() == 3 : "Error in Landscape::getNeighbors(int, int)";
            ArrayList<Cell> neighbors4 = l1.getNeighbors(6, 0);
            assert neighbors4.size() == 3 : "Error in Landscape::getNeighbors(int, int)";

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    ArrayList<Cell> neighbor = l1.getNeighbors(i, j);
                    assert neighbor.size() == 8 : "Error in Landscape::getNeighbors(int, int)";
                }
            }

        }

        // case 7: testing advance()
        {
            // set up
            Landscape l1 = new Landscape(6, 3, 0.25);
            l1.reset();
            System.out.println(l1);
            l1.advance();
            System.out.println(l1);

            // verify
            System.out.println(l1);

            // test
            l1.advance();
            for (int i = 0; i < l1.getRows(); i++) {
                for (int j = 0; j < l1.getCols(); j++) {
                    Cell c = l1.getCell(i, j);
                    assert c.getAlive() || !c.getAlive() : "Error in Landscape::advance()";
                }
            }

        }
        System.out.println("***Test Complete***");
    }

    public static void main(String[] args) {

        landscapeTests();
    }
}