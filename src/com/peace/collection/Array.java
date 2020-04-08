package com.peace.collection;

/*
Built in array in java
*/
class Array {
    public static void main(String args[]) {
        // declara and init
        int[] arr = { 1, 2, 3, 7 };

        // traverse and print value
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();

        // size
        System.out.println("Size: " + arr.length);
        System.out.println("Index from 0 to " + (arr.length - 1));

        // declare and init
        int[][] mat = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

        // size
        System.out.println("Mat size: " + mat.length);
        System.out.println("Mat[0] size: " + mat[0].length);

        // get value by indexing
        System.out.println(mat[3][0] + " "); // 7

        // traverse
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();

        // traverse 2
        for (int[] vec : mat) {
            for (int val : vec) {
                System.out.print(val + " ");
            }
        }
        System.out.println();
    }
}