class Solution {
public:
    bool isPossibleToRearrange(string s, string t, int k) {
        int n = s.size();
        int sz = n / k;

        unordered_map<string, int> count;

        for (int i = 0; i < n; i += sz) {
            count[s.substr(i, sz)]++;
        }

        for (int i = 0; i < n; i += sz) {
            count[t.substr(i, sz)]--;
        }

        for (auto &p : count) {
            if (p.second != 0) {
                return false;
            }
        }
        return true;
    }
};
