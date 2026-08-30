package HeapImp;

import java.util.*;

public class L632 {

    static class Solution {

        static class Triplate implements Comparable<Triplate> {
            int r;
            int c;
            int d;

            public Triplate(int r, int c, int d) {
                this.r = r;
                this.c = c;
                this.d = d;
            }

            public int compareTo(Triplate other) {
                return this.d - other.d;
            }
        }

        public int[] smallestRange(List<List<Integer>> nums) {

            int n = nums.size();
            PriorityQueue<Triplate> pq = new PriorityQueue<>();

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int val = nums.get(i).get(0);
                pq.add(new Triplate(i, 0, val));
                max = Math.max(max, val);
            }

            int d = Integer.MAX_VALUE;
            int st = 0, end = 0;

            while (true) {
                Triplate curr = pq.poll();
                int data = curr.d;

                if (max - data < d) {
                    st = data;
                    end = max;
                    d = max - data;
                }

                if (curr.c + 1 == nums.get(curr.r).size())
                    break;

                int nextVal = nums.get(curr.r).get(curr.c + 1);
                pq.add(new Triplate(curr.r, curr.c + 1, nextVal));

                max = Math.max(max, nextVal);
            }

            return new int[]{st, end};
        }
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] ans = obj.smallestRange(nums);

        System.out.println("Smallest Range: [" + ans[0] + ", " + ans[1] + "]");
    }
}