package src.com.peace.sort;

class MergeSort {

    public void mergesort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        mergesort(arr, lo, mid);
        mergesort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);
    }

    public void merge(int[] arr, int lo, int mid, int hi) {
        // Crio dois aux[] contendo cada metade do array [lo - mid] [mid+1 - hi]
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] auxl = new int[n1];
        int[] auxr = new int[n2];

        // fill auxl with arr[lo to n1]
        for (int i = 0; i < n1; ++i)
            auxl[i] = arr[lo + i];
        // fill auxr with arr[mid + 1 to n2]
        for (int j = 0; j < n2; ++j)
            auxr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            // arr[k] recebe o menor de auxl or auxr
            if (auxl[i] <= auxr[j]) {
                arr[k] = auxl[i];
                i++;
            } else {
                arr[k] = auxr[j];
                j++;
            }
            k++;
        }
        // copia o restante if any
        while (i < n1) {
            arr[k] = auxl[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = auxr[j];
            j++;
            k++;
        }
    }

    public void print(int[] arr) {
        int i;
        int n = arr.length; // 4
        for (i = 0; i < n; i++) { // 0 1 2 3 < 4
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void print(int[] arr, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 7, 2, 1, 6, 8, 5, 3, 4 };
        MergeSort obj = new MergeSort();
        obj.print(arr);
        obj.mergesort(arr, 0, arr.length - 1); // arr, lowest index is 0, highest valid index n-1
        obj.print(arr);
    }
}