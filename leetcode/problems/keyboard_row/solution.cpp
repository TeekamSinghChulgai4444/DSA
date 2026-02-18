
class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        map<char, int> mp;

        for (char c : string("qwertyuiop"))
            mp[c] = 0;
        for (char c : string("asdfghjkl"))
            mp[c] = 1;
        for (char c : string("zxcvbnm"))
            mp[c] = 2;

        vector<string> ans;

        for (auto& word : words) {
            bool check = true;
            int row = mp[tolower(word[0])];

            for (char c : word) {
                if (mp[tolower(c)] != row) {
                    check = false;
                    break;
                }
            }

            if (check)
                ans.push_back(word);
        }

        return ans;
    }
};
