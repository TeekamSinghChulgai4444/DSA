class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {

        int n = temp.size();
        vector<int> answer(n, 0);
        stack<int> s; 
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && temp[s.top()] <= temp[i]) {
                s.pop();
            }
            if (!s.empty()) {
                answer[i] = s.top() - i;
            }
            s.push(i);
        }

        return answer;
        
    }
};