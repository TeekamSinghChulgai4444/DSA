class Solution {
    public int[] sortArray(int[] nums) {

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
}