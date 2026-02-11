class Solution {
public:
    int maxi = 0;

    bool check(string s, vector<string>& ans) {
        for (auto a : ans) {
            if (a == s) {
                return false;
            }
        }
        return true;
    }

    void value(int st, int n, vector<string>& ans, string s) {

        if (st == n) {
            if (ans.size() > maxi) {
                maxi = ans.size();
            }
            return;
        }

        for (int i = st + 1; i <= n; i++) {
            string temp = s.substr(st, i - st);

            if (check(temp, ans)) {
                ans.push_back(temp);
                value(i, n, ans, s);
                ans.pop_back();   // backtracking
            }
        }
    }

    int maxUniqueSplit(string s) {
        vector<string> ans;
        int n = s.length();
        value(0, n, ans, s);
        return maxi;
    }
};