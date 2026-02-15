package src;

public class Median3QuickSort {

    public static void sort(int[] a) {
        if (a == null || a.length <= 1)
            return;
        quicksortMedian3(a, 0, a.length - 1);
    }

    // QUICKSORT_MEDIAN3(A, lo, hi)
    public static void quicksortMedian3(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = medianOfThree(a, lo, hi);
        swap(a, mid, hi); // SWAP(A[mid], A[hi]) so Lomuto uses a[hi] as pivot

        int p = partitionLomuto(a, lo, hi); // p := partition(A, lo, hi) // Lomuto’s scheme
        quicksortMedian3(a, lo, p - 1);
        quicksortMedian3(a, p + 1, hi);
    }

    // MEDIAN_OF_THREE(A, lo, hi)
    private static int medianOfThree(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;

        if (a[lo] > a[mid])
            swap(a, lo, mid);
        if (a[mid] > a[hi])
            swap(a, mid, hi);
        if (a[lo] > a[mid])
            swap(a, lo, mid);

        return mid;
    }

    // Lomuto partition (pivot is a[hi])
    private static int partitionLomuto(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo; // boundary for <= pivot

        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
