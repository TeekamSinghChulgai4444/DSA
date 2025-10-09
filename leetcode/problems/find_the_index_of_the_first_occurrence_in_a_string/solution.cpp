class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.size();
        int m = needle.size();

        // Loop through haystack up to the point where needle can fit
        for (int i = 0; i <= n - m; i++) {
            // Compare substring from haystack with needle
            if (haystack.substr(i, m) == needle)
                return i;  // Found first occurrence
        }
        return -1;  // Not found
    }
};