package com.peace.amz;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Tenho um grid de servidores, 0 caso o server nao tenha o arquivo e 1 caso ja tenha o arquivo
 * Leva 1 hora para um server espalhar para todos os vizinhos
 * Qual o minimo de horas para enviar um arquivo para todos os servidores?
 */

public class MinHours {

    public int minimumHours(int rows, int cols, ArrayList<ArrayList<Integer>> grid) {
        // expected return
        int minimumHours = 0;

        // declare a boolean matrix and initialize with false
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                visited[r][c] = false;
            }
        }

        // insert all servers with file (equal 1) into queue
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[] { r, c }); // r,c
                    visited[r][c] = true;
                }
            }
        }

        if (queue.isEmpty()) {
            return -1;
        }

        // do a bfs spreading the files
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                int[] server = queue.poll();
                size--;

                // push adjacents if not out of bounds or already visisted
                int[][] dirs = new int[][] { { -1, 0 }, { +1, 0 }, { 0, +1 }, { 0, -1 } };
                for (int[] dir : dirs) {
                    // compute index of new row and column
                    int nr = server[0] + dir[0];
                    int nc = server[1] + dir[1];

                    // check bounds
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }

                    // check if already visited
                    if (visited[nr][nc] == true) {
                        continue;
                    }
                    visited[nr][nc] = true;

                    queue.offer(new int[] { nr, nc });
                }
            }

            // all level visited, increment 1 hour to spread again
            minimumHours++;
        }

        // it always count 1 hour more
        return minimumHours - 1;
    }

    void printGrid(int rows, int cols, ArrayList<ArrayList<Integer>> grid) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(grid.get(r).get(c) + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void main(String args[]) {
        // declare and initialize input
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(0);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);

        grid.add(row1);
        grid.add(row2);
        grid.add(row3);

        new MinHours().printGrid(3, 3, grid);

        int hours = new MinHours().minimumHours(3, 3, grid);

        System.out.println("Minimal hours is " + hours);
    }
}