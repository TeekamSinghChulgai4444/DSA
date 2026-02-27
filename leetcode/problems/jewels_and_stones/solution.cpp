class Solution {
public:
    int numJewelsInStones(string j, string s) {
        vector<int> visit(52, false);
        for (int i = 0; i < j.length(); i++) {
            if (j[i] >= 'A' && j[i] <= 'Z') {
                visit[j[i] - 'A'] = true;

            } 
            else {
                visit[j[i] - 'a' + 26] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                if (visit[s[i] - 'A']) {
                    count++;
                }
            }

                else {
                    if (s[i] >= 'a' && s[i] <= 'z') {
                        if (visit[s[i] - 'a' + 26]) {
                            count++;
                        }
                    }
                }
        }
                return count;
        
        }
    };