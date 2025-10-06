class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";  // Edge case: empty list

        string prefix = strs[0]; // Take first string as initial prefix
        for (int i = 1; i < strs.size(); i++) {
            // Compare prefix with each string
            while (strs[i].find(prefix) != 0) {
                // Shorten prefix until it matches
                prefix = prefix.substr(0, prefix.size() - 1);
                if (prefix.empty()) return "";
            }
        }
        return prefix;
    }
};