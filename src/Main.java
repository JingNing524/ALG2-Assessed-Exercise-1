package src;

public class Main {

    public static void main(String[] args) throws Exception {

        // Load dataset
        int[] original = IntFileReader.readAllInts("Dutch.txt");

        // Clone so both algorithms get identical input
        int[] median3 = original.clone();
        int[] threeWay = original.clone();

        // ---------- Median-of-3 ----------
        long start = System.nanoTime();
        Median3QuickSort.sort(median3);
        long medianTime = System.nanoTime() - start;

        // ---------- Three-Way ----------
        start = System.nanoTime();
        ThreeWayQuickSort.sort(threeWay);
        long threeWayTime = System.nanoTime() - start;

        // Results
        System.out.println("Median-of-3 runtime (ns): " + medianTime);
        System.out.println("Three-Way runtime (ns):   " + threeWayTime);

        // Safety check
        System.out.println("Median sorted? " + isSorted(median3));
        System.out.println("ThreeWay sorted? " + isSorted(threeWay));
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
}
