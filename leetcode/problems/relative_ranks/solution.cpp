class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        int n = score.size();
        vector<string> answer(n);

        vector<pair<int,int>> temp;
        for(int i = 0; i < n; i++){
            temp.push_back({score[i], i});
        }

        sort(temp.begin(), temp.end(), greater<>());

        for(int i = 0; i < n; i++){
            int idx = temp[i].second;

            if(i == 0) answer[idx] = "Gold Medal";
            else if(i == 1) answer[idx] = "Silver Medal";
            else if(i == 2) answer[idx] = "Bronze Medal";
            else answer[idx] = to_string(i + 1);
        }

        return answer;
    }
};
