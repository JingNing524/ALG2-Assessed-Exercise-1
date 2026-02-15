package src;

public class Main {

    public static void main(String[] args) throws Exception {

        // Part 1b

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

        // Part 1c

        System.out.println();

        int[] sizes = { 1000, 2000, 4000, 8000 };

        for (int n : sizes) {

            int[] killer = KillerInput.generate(n);

            long tStart = System.nanoTime();
            Median3QuickSort.sort(killer);
            long time = System.nanoTime() - tStart;

            System.out.println("n = " + n +
                    " -> " + (time / 1_000_000) + " ms" +
                    " | sorted? " + isSorted(killer));
        }

        // Part 2

        System.out.println();

        // Example dataset (videoId = index)
        int[] views = { 45, 900, 12, 760, 33, 1500, 499, 888, 1200 };

        int k = 3;

        int[] topVideos = TopKVideos.topK(views, k);

        System.out.println("Top " + k + " most viewed videos:");

        for (int id : topVideos) {
            System.out.println("Video ID: " + id +
                    " | Views: " + views[id]);
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
}
