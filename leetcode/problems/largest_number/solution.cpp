class Solution {
public:
    string largestNumber(vector<int>& nums) {
        string ans;
        int sentinel = INT_MAX;

        for (int i = 0; i < nums.size(); i++) {
            int maxx = -1;

            for (int j = 0; j < nums.size(); j++) {
                if (nums[j] == sentinel) continue;

                if (maxx == -1) {
                    maxx = j;
                    continue;
                }

                string a = to_string(nums[j]);
                string b = to_string(nums[maxx]);

                if (a + b > b + a) {
                    maxx = j;
                }
            }

            ans += to_string(nums[maxx]);
            nums[maxx] = sentinel; // mark as used
        }

        // Edge case: if the result starts with '0', return "0"
        if (ans[0] == '0') return "0";

        return ans;
    }
};