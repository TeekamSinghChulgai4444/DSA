class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> arr = {-1, -1};
        int i = 0;
        int n = nums.size() - 1;

        while (i <= n) {
            if (nums[i] == target && arr[0] == -1) arr[0] = i;
            if (nums[n] == target && arr[1] == -1) arr[1] = n;
            if (arr[0] != -1 && arr[1] != -1) return arr;
            if (arr[0] == -1) i++;
            if (arr[1] == -1) n--;
        }

        return arr;
    }
};