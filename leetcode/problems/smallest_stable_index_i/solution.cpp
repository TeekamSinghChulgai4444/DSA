class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {

        int n = nums.size();

        vector<int> left(n);
        vector<int> right(n);

        int maxx = INT_MIN;

        for (int i = 0; i < n; i++) {
            maxx = max(maxx, nums[i]);
            left[i] = maxx;
        }

        int minn = INT_MAX;

        for (int i = n - 1; i >= 0; i--) {
            minn = min(minn, nums[i]);
            right[i] = minn;
        }

        for (int i = 0; i < n; i++) {
            int ans = left[i] - right[i];
            if (ans <= k) {
                return i;
            }
        }

       

        return -1;
    }
};