class Solution {
public:
    int mirrorFrequency(string s) {
        int l = s.length();
        vector<int> alphabet(26);
        vector<int> digit(10);
        int ans=0;

        for (int i = 0; i < l; i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                int ind = s[i] -'a';
                alphabet[ind]++;
            }
            if (s[i] >= 0 && s[i] <= '9') {
                int ind = s[i]-'0';
                digit[ind]++;
            }
        }
        int i = 0;
        int j = 25;

        while (i < j) {
            ans += abs(alphabet[i] - alphabet[j]);
            i++;
            j--;
        }
        i = 0;
        j = 9;

        while (i < j) {
            ans += abs(digit[i] - digit[j]);
            i++;
            j--;
        }
        return ans;
    }
};