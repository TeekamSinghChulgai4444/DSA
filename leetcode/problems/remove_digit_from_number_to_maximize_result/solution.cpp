class Solution {
public:
    string removeDigit(string number, char digit) {

        string ans;
        int l = number.length();
        string temp;

        for (int i = 0; i < l; i++) {
            if (number[i] == digit) {
                string temp1 = temp + number.substr(i + 1);
                if ( temp1 > ans) {
                    ans = temp1;
                }
            }
            temp += number[i];
        }
        return ans;
    }
};