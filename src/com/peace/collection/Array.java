package src.com.peace.collection;

/*
Built in array in java
*/
class Array {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[][] mat = {{1,2},{3,4},{5,6},{7,8}};
        System.out.print(mat[3][0] + " ");
    }
}