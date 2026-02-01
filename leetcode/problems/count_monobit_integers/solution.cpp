class Solution {
public:
    int countMonobit(int n) {
        long long val = 1;
        int count = 1; 

        while (val <= n) {
            count++;
            val = (val << 1) | 1;
        }

        return count;
    }
};