class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;

        // Collect non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ans.add(nums[i]);
            } else {
                count++;
            }
        }

        // Add zeros at the end
        for (int i = 0; i < count; i++) {
            ans.add(0);
        }

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans.get(i);
        }
    }
}