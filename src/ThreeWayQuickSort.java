package src;

public class ThreeWayQuickSort {

    public static void sort(int[] a) {
        if (a == null || a.length <= 1)
            return;
        threeWayQuickSort(a, 0, a.length - 1);
    }

    // THREE_WAY_QUICKSORT(A, lo, hi)
    public static void threeWayQuickSort(int[] a, int lo, int hi) {
        // if lo >= hi return
        if (lo >= hi)
            return;

        // pivot := A[lo]
        int pivot = a[lo];

        // lt := lo, gt := hi, i := lo + 1
        int lt = lo;
        int gt = hi;
        int i = lo + 1;

        // while i <= gt
        while (i <= gt) {
            // if A[i] < pivot
            if (a[i] < pivot) {
                // SWAP(A[lt], A[i])
                swap(a, lt, i);
                // lt := lt + 1, i := i + 1
                lt++;
                i++;
            }
            // else if A[i] > pivot
            else if (a[i] > pivot) {
                // SWAP(A[i], A[gt])
                swap(a, i, gt);
                // gt := gt - 1
                gt--;
                // (do NOT increment i here, because the swapped-in element at i is unprocessed)
            }
            // else i := i + 1
            else {
                i++;
            }
        }

        // THREE_WAY_QUICKSORT(A, lo, lt - 1)
        threeWayQuickSort(a, lo, lt - 1);

        // THREE_WAY_QUICKSORT(A, gt + 1, hi)
        threeWayQuickSort(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
