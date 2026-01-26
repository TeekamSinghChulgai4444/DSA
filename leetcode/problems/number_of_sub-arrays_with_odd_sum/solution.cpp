class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        const int MOD = 1e9 + 7;

        long long ans = 0;
        int odd = 0, even = 1; // empty prefix is even
        int prefixSum = 0;

        for (int x : arr) {
            prefixSum += x;

            if (prefixSum % 2 == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else {
                ans = (ans + even) % MOD;
                odd++;
            }
        }
        return ans;
    }
};
