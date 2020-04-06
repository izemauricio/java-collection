package com.peace.amz;

import java.util.*;

/*
 * input is an array of integer {1 0 1 1 0 1 0}
 * cada dia passado, uma cell fica 0 se seus vizinhos forem ambos 0
 * retorne o estado apois n dias
*/

class Questao1 {

    public ArrayList<Integer> cellCompete(int[] states, int days) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        // for each day
        for (int day = 0; day < days; day++) {
            // create new state
            int[] ns = new int[8];

            // for each cell in old state
            for (int i = 0; i < 8; i++) {
                // edge case of first cell
                if (i == 0) {
                    if (states[1] == 0) {
                        ns[i] = 0;
                    } else {
                        ns[i] = 1;
                    }
                }

                // edge case of last item
                else if (i == 7) {
                    if (states[6] == 0) {
                        ns[i] = 0;
                    } else {
                        ns[i] = 1;
                    }
                }

                // rest of cells i == [1 to 6]
                else {
                    // 0 e 0
                    if (states[i - 1] == 0 && states[i + 1] == 0) {
                        ns[i] = 0;
                    }
                    // 1 e 1
                    if (states[i - 1] == 1 && states[i + 1] == 1) {
                        ns[i] = 0;
                    }
                    // 0 e 1
                    if (states[i - 1] == 0 && states[i + 1] == 1) {
                        ns[i] = 1;
                    }
                    // 1 e 0
                    if (states[i - 1] == 1 && states[i + 1] == 0) {
                        ns[i] = 1;
                    }
                }
            }

            // update state to new state
            states = ns;
        }

        // array to list
        for (int i = 0; i < states.length; i++) {
            ret.add(states[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        // declare and initialize input
        int[] input = new int[] { 1, 0, 1, 1, 0, 0, 0, 1 };

        ArrayList<Integer> ret = new Questao1().cellCompete(input, 2);

        // imprime output
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }
}