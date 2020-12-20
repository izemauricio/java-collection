package com.peace.sort;

public class QuickSort {

    public void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        // get the pivot index where everything left is smaller and everything right is
        // bigger
        // make sure everything left than PI is smaller than PI (but not sorted) and
        // everything right is bigger (but not sorted)
        int pi = partition(arr, lo, hi);

        // solve/sort the two halves, ignoring the pi value
        quicksort(arr, lo, pi - 1); // the sub arr which all values are smaller than value at pi
        quicksort(arr, pi + 1, hi); // the sub arr which all values are bigger than value at pi
    }

    int partition(int[] arr, int lo, int hi) {
        final int pv = arr[hi]; // our pivot value, constant, always the value at index hi
        int pi = lo; // pivot index

        // iterate over all elements to make sure that all values less than pivot are at left of pivot index
        int i = lo;
        while (i < hi) {
            if (arr[i] < pv) {
                // swap current value at arr[i] with arr[pi] 
                // since arr[i] is lower than pivot
                swap(arr, pi, i);
                pi++;
            } else {
                // just increment i to keep walking while arr[i] is bigger or equal than pivot
            }
            i++;
        }

        // everything left of pi is less than pivot
        // everything right of pi is bigger or equal than pivot
        // swap arr[pi] value with pivot (arr[hi]) value
        swap(arr, pi, hi);

        // retorna index garantido que tudo left é menor e tudo right é maior
        return pi;
    }

    // swap index i with index j
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("hi");
        int[] arr = new int[] { 7, 2, 1, 6, 8, 5, 3, 4 };
        QuickSort qs = new QuickSort();
        qs.print(arr);
        qs.quicksort(arr, 0, arr.length - 1); // low index and high index = 0..n-1
        qs.print(arr);

    }
}