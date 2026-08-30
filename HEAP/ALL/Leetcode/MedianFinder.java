package Leetcode;

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> min; // right side (larger)
    PriorityQueue<Integer> max; // left side (smaller)

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if (max.isEmpty() || num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        // Step 2: balance heaps
        if (max.size() > min.size() + 1) {
            min.add(max.poll());
        } else if (min.size() > max.size() + 1) {
            max.add(min.poll());
        }
    }

    public double findMedian() {

        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }

        return (max.size() > min.size()) ? max.peek() : min.peek();
    }
}