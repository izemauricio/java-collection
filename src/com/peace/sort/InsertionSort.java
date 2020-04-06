package com.peace.sort;

class InsertionSort {
    void insertsort(int[] arr) {
        int hi = arr.length - 1; // highest valid index of array
        for (int i = 1; i < hi; i++) {
            int v = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > v) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = v;
        }
    }

    void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr;
        arr = new int[] { 1, 4, 2, 8, 9, 6 };
        is.print(arr);
        is.insertsort(arr);
        is.print(arr);
    }
}