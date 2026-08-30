package Leetcode;
import java.util.*;

public class SortArrayUsingPQ {

    public static int[] sortArray(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            nums[i++] = minHeap.poll();
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};

        nums = sortArray(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}