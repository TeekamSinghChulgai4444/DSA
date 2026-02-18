class Solution {
        public int[] shortestToChar(String s, char c) {
            int n = s.length();
            int[] result = new int[n];

            // First pass: left to right
            int prev = -n;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    prev = i;
                }
                result[i] = i - prev;
            }

            // Second pass: right to left
            prev = 2 * n;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == c) {
                    prev = i;
                }
                result[i] = Math.min(result[i], prev - i);
            }

            return result;
        }
    }