package src;

public class MinHeap {
    private final int[] videoId;
    private final int[] views;
    private int size;

    public MinHeap(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be > 0");
        this.videoId = new int[capacity];
        this.views = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return videoId.length;
    }

    public boolean isFull() {
        return size == videoId.length;
    }

    // Root (minimum views)
    public int minViews() {
        if (size == 0)
            throw new IllegalStateException("heap empty");
        return views[0];
    }

    public int minVideoId() {
        if (size == 0)
            throw new IllegalStateException("heap empty");
        return videoId[0];
    }

    // Insert (assumes not full)
    public void insert(int id, int v) {
        if (isFull())
            throw new IllegalStateException("heap full");
        videoId[size] = id;
        views[size] = v;
        siftUp(size);
        size++;
    }

    // Replace root with (id, v) then restore heap
    public void replaceRoot(int id, int v) {
        if (size == 0)
            throw new IllegalStateException("heap empty");
        videoId[0] = id;
        views[0] = v;
        siftDown(0);
    }

    // Build heap from existing first 'size' elements
    public void heapify() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    // Used if you want to bulk-load (optional)
    public void setAt(int index, int id, int v) {
        videoId[index] = id;
        views[index] = v;
    }

    public void setSize(int newSize) {
        if (newSize < 0 || newSize > videoId.length)
            throw new IllegalArgumentException("bad size");
        size = newSize;
    }

    // Return heap content as arrays (order is heap order, not sorted)
    public int[] getVideoIds() {
        int[] out = new int[size];
        System.arraycopy(videoId, 0, out, 0, size);
        return out;
    }

    public int[] getViews() {
        int[] out = new int[size];
        System.arraycopy(views, 0, out, 0, size);
        return out;
    }

    // ----------------- heap helpers -----------------

    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (views[i] >= views[p])
                break;
            swap(i, p);
            i = p;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && views[left] < views[smallest])
                smallest = left;
            if (right < size && views[right] < views[smallest])
                smallest = right;

            if (smallest == i)
                break;
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int tmpId = videoId[i];
        videoId[i] = videoId[j];
        videoId[j] = tmpId;

        int tmpV = views[i];
        views[i] = views[j];
        views[j] = tmpV;
    }
}
