package Leetcode;

import java.util.*;

public class topKFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int i = k - 1;

        while (!pq.isEmpty()) {
            ans[i--] = pq.poll().num;
        }

        return ans;
    }

    public static void main(String[] args) {
        topKFrequentElement obj = new topKFrequentElement();

        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }
}

class Pair implements Comparable<Pair> {
    int num;
    int freq;

    Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair other) {
        return this.freq - other.freq;
    }
}