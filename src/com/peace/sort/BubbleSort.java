package com.peace.sort;

class BubbleSort {

    public void sort(int[] arr) {
        int N = arr.length - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                //System.out.println(i + " " + j);
                // if curr is bigger than next
                if (arr[j] > arr[j + 1]) {
                    // swap values
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();

        int[] arr;
        arr = new int[] { 1, 4, 2, 8, 9, 6 };

        sort.print(arr);
        sort.sort(arr);
        sort.print(arr);
    }
}