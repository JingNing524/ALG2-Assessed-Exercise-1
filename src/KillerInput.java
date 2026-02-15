package src;

public class KillerInput {

    // Generates a permutation of 1..n (positive, no duplicates)
    public static int[] generate(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive");

        int[] a = new int[n];
        int idx = 0;

        // smallest first
        a[idx++] = 1;

        // then evens: 2,4,6,...
        for (int x = 2; x <= n; x += 2) {
            a[idx++] = x;
        }

        // then odds (starting at 3): 3,5,7,...
        for (int x = 3; x <= n; x += 2) {
            a[idx++] = x;
        }

        return a;
    }

    // If you want the exact hint style 0..n-1, use:
    public static int[] generateZeroBased(int n) {
        int[] a = generate(n);
        for (int i = 0; i < a.length; i++)
            a[i] -= 1;
        return a;
    }
}
