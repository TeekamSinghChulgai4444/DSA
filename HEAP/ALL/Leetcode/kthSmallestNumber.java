package Leetcode;

import java.util.*;

public class kthSmallestNumber {

    public static int smallestNumber(int[] arr, int n, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll(); // remove largest
                maxHeap.add(arr[i]);
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = smallestNumber(arr, arr.length, k);
        System.out.println("Kth Smallest: " + result);
    }
}