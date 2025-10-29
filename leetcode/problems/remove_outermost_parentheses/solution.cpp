class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        int l = s.length();
        int i = 0;
        int open = 0;

        while (i < l) {
            if (s[i] == '(') {
                if (open > 0) {
                    ans += '(';
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    ans += ')';
                }
            }
            i++;
        }

        return ans;
    }
};