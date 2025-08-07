class Solution {
public:
    void find_all_combination(vector<int>& arr, vector<vector<int>>& result, vector<int>& temp, int target, int start) {
        if (target == 0) {
            result.push_back(temp);
            return;
        }

        for (int i = start; i < arr.size(); ++i) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break; 
            temp.push_back(arr[i]);
            find_all_combination(arr, result, temp, target - arr[i], i + 1);
            temp.pop_back(); 
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end()); // Sort to handle duplicates
        vector<vector<int>> result;
        vector<int> temp;
        find_all_combination(candidates, result, temp, target, 0);
        return result;
    }
};