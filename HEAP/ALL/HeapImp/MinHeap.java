package HeapImp;

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    void add(int val) {
        arr.add(val);
        heapifyUp(arr.size() - 1);
    }

    void heapifyUp(int i) {
        if (i == 0) return;

        int parent = (i - 1) / 2;

        if (arr.get(i) < arr.get(parent)) {
            swap(i, parent);
            heapifyUp(parent);
        }
    }

    void heapifyDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
            smallest = left;
        }

        if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    void pop() {
        int size = arr.size();
        if (size == 0) return;

        if (size == 1) {
            arr.clear();
            return;
        }

        arr.set(0, arr.get(size - 1));
        arr.remove(size - 1);

        heapifyDown(0);
    }

    void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {

    }
}