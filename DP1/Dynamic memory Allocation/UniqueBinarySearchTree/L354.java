package UniqueBinarySearchTree;

import java.util.*;

public class L354 {

    public class Envelope implements Comparable<Envelope> {
        int w;
        int h;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Envelope o) {
            if (this.w == o.w) {
                return o.h - this.h;
            }
            return this.w - o.w;
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;

        Envelope[] arr = new Envelope[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }

        Arrays.sort(arr);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i].h < arr[j].h) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        return max;
    }
}