class MergeSort {
    public void mergesort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        System.out.println("Calling mergesort(arr, lo, mid)");
        mergesort(arr, lo, mid);
        System.out.println("Calling mergesort(arr, mid + 1, hi)");
        mergesort(arr, mid + 1, hi);
        System.out.println("Calling merge(arr, lo, mid, hi)");
        merge(arr, lo, mid, hi);
    }

    public void merge(int[] arr, int lo, int mid, int hi) {
        // junta dois arrays [lo-mid] e [mid+1-hi] pegando o menor de cada um

        System.out.println("Sou merge(" + lo + ", " + mid + ", " + hi + ")");
        print(arr, lo, hi);

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

        print(arr, lo, hi);
    }

    public void swap(int[] arr, int l, int r) {
        if (l >= r || r < 0 || l >= arr.length)
            return;

        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;

        this.swap(arr, l + 1, r - 1);
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
        int[] arr = { 7, 5, 3, 1};
        MergeSort obj = new MergeSort();

        obj.mergesort(arr, 0, arr.length - 1);

    }
}