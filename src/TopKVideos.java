package src;

public class TopKVideos {

    // Returns the video IDs of the k most viewed videos (heap order).
    public static int[] topK(int[] viewCounts, int k) {
        if (k <= 0)
            return new int[0];
        if (viewCounts == null)
            throw new IllegalArgumentException("viewCounts is null");
        if (k > viewCounts.length)
            k = viewCounts.length;

        MinHeap heap = new MinHeap(k);

        // 1) Load first k items
        for (int i = 0; i < k; i++) {
            heap.insert(i, viewCounts[i]);
        }

        // 2) Scan remaining n-k items
        for (int i = k; i < viewCounts.length; i++) {
            int v = viewCounts[i];
            if (v > heap.minViews()) {
                heap.replaceRoot(i, v);
            }
        }

        return heap.getVideoIds();
    }

    // Optional: if you want (id, views) pairs back
    public static Result topKWithViews(int[] viewCounts, int k) {
        if (k <= 0)
            return new Result(new int[0], new int[0]);
        if (viewCounts == null)
            throw new IllegalArgumentException("viewCounts is null");
        if (k > viewCounts.length)
            k = viewCounts.length;

        MinHeap heap = new MinHeap(k);

        for (int i = 0; i < k; i++)
            heap.insert(i, viewCounts[i]);

        for (int i = k; i < viewCounts.length; i++) {
            int v = viewCounts[i];
            if (v > heap.minViews())
                heap.replaceRoot(i, v);
        }

        return new Result(heap.getVideoIds(), heap.getViews());
    }

    public static class Result {
        public final int[] videoIds;
        public final int[] views;

        public Result(int[] videoIds, int[] views) {
            this.videoIds = videoIds;
            this.views = views;
        }
    }
}
