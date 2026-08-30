package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestNumber {

    public static int largestNumber(int [] arr , int n , int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // mtyin heap

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (arr[i] < minHeap.peek()) {
                minHeap.poll(); // remove largest
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

            int[] arr = {7, 10, 4, 3, 20, 15};
            int k = 3;
            int result = largestNumber(arr, arr.length, k);
            System.out.println("Kth Smallest: " + result);

    }
}
