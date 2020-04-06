package com.peace.amz;

import java.util.ArrayList;

/*
 * tenho um grid representando uma cidade, onde 1 representa um parque e 0 um predio
 * quero instalar um truck em cada bloco contendo parques continuos
 * retorne o numero de trucks necessarios para um dado grid
*/

public class NumTrucks {
    int numberAmazonTreasureTruck(int rows, int cols, ArrayList<ArrayList<Integer>> grid) {
        int numberOfTrucks = 0;

        // for each block of grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // get the block type
                int type = grid.get(i).get(j);

                // get all adjacents of block (north, south, west and east)
                boolean up = visited(i + 1, j, rows, cols, grid);
                boolean down = visited(i - 1, j, rows, cols, grid);
                boolean left = visited(i, j - 1, rows, cols, grid);
                boolean right = visited(i, j + 1, rows, cols, grid);

                // caso seja park e nenhum adjacente ja tenha sido visitado, tenho um novo bloco
                // e preciso de um novo truck
                if (!up && !left && !right && !down && type == 1) {
                    // incrementa numero de truck necessarios para a cidade
                    numberOfTrucks++;
                    // marca como visitado
                    grid.get(i).set(j, -1);
                }

                // caso seja park e tiver algum adjacente visitado, este park faz parte de um
                // bloco contiguo
                else if (type == 1) {
                    ArrayList<Integer> row = grid.get(i);
                    row.set(j, -1);
                }

                // o block é uma cidade, ignora
                else {
                }
            }
        }

        return numberOfTrucks;
    }
    
    /*
     *  Verifica se bloco esta out of bounds
     */
    public boolean outOfBounds(int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return true;
        }
        return false;
    }

    /*
     *  Verifica se bloco ja foi visitado 
     */
    public boolean visited(int i, int j, int rows, int cols, ArrayList<ArrayList<Integer>> grid) {
        // caso out of bounds, nao foi visitado
        if (outOfBounds(i, j, rows, cols)) {
            return false;
        }

        // verifica se bloco tem a flag -1, escolhida para marcar visitados
        if (grid.get(i).get(j) == -1) {
            return true;
        }

        // nao foi visitado
        return false;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(1);
        row1.add(0);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(0);
        row2.add(0);
        row2.add(0);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);
        row3.add(0);
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(1);
        row4.add(1);
        row4.add(1);
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);
        int res = new NumTrucks().numberAmazonTreasureTruck(4, 4, grid);
        System.out.println("numberOfTrucks = " + res);
    }
}