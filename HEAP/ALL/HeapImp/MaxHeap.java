package HeapImp;

import java.util.*;

public class MaxHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    MaxHeap() {
        arr.add(Integer.MAX_VALUE);
    }

    void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    void HeapUp(int s) {
        if (s == 1) return;

        int parent = s / 2;

        if (arr.get(s) > arr.get(parent)) {
            swap(s, parent);
            HeapUp(parent);
        }
    }

    void push(int a) {
        arr.add(a);
        HeapUp(arr.size() - 1);
    }

    void heapDown(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;

        if (left < arr.size() && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < arr.size() && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapDown(largest);
        }
    }

    void pop() {
        if (arr.size() == 1) return;

        arr.set(1, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);

        heapDown(1);
    }

    public static void main(String[] args) {

    }
}