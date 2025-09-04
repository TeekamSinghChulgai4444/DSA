#include <unordered_set>

class Solution {
public:
    bool ans;
    std::unordered_set<int> seen_numbers;

    void helper(int n) {
        if (n == 1) {
            ans = true;
            return;
        }

        if (seen_numbers.count(n)) {
            ans = false;
            return;
        }

        seen_numbers.insert(n);
        
        int next_n = 0;
        int temp_n = n;
        while (temp_n > 0) {
            int digit = temp_n % 10;
            next_n += digit * digit;
            temp_n /= 10;
        }

        helper(next_n);
    }

    bool isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        // Reset class members for a fresh run
        ans = false;
        seen_numbers.clear();

        helper(n);
        return ans;
    }
};