package Leetcode;
import java.util.*;

public class sortAKsortedArray {

    public static int[] sortedArray(int[] arr, int k, int n) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[n];

        int i = 0;

        for (i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        int j = 0;

        while (i < n) {
            ans[j++] = minHeap.poll();
            minHeap.add(arr[i++]);
        }

        while (!minHeap.isEmpty()) {
            ans[j++] = minHeap.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        int[] result = sortedArray(arr, k, arr.length);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}