class Solution {
public:
    long long countCommas(long long n) {

        string temp;
        int rem;
        long long ans = 0;
        long long bcd;

        while (n > 999) {
            
            temp = to_string(n);
            int l = temp.length();
            rem = (l-1) / 3 ;
            string temppp;

            for (int i = 0; i < l - 1; i++) {
                temppp.push_back('9');
            }
            bcd = stoll(temppp);
            ans = ans + rem * (n - bcd);
            n = bcd;
        }

        return ans;
    }
};