class Solution {
public:
    bool isInvalid(vector<int>& nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    int minimumPairRemoval(vector<int>& nums) {
        int operation = 0;

        while (!isInvalid(nums)) {   // ✅ FIXED
            int LowSum = INT_MAX;
            int index = 0;

            for (int i = 0; i < nums.size() - 1; i++) {
                int tempSum = nums[i] + nums[i + 1];
                if (tempSum < LowSum) {
                    LowSum = tempSum;
                    index = i;
                }
            }

            nums[index] = LowSum;
            nums.erase(nums.begin() + index + 1);
            operation++;
        }

        return operation;
    }
};
