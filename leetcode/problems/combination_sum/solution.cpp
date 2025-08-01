class Solution {
public:
    vector<vector<int>> s;

    bool exists(const vector<int>& temp) {
        vector<int> sorted_temp = temp;
        sort(sorted_temp.begin(), sorted_temp.end());
        for (auto& v : s) {
            vector<int> sorted_v = v;
            sort(sorted_v.begin(), sorted_v.end());
            if (sorted_v == sorted_temp) return true;
        }
        return false;
    }

    void combination(vector<int>& arr, int i, int target,
                     vector<vector<int>>& result, vector<int>& temp) {
        if (target == 0) {
            if (!exists(temp)) {
                result.push_back(temp);
                s.push_back(temp);
            }
            return;
        }

        if (target < 0 || i >= arr.size()) return;

        temp.push_back(arr[i]);
        combination(arr, i, target - arr[i], result, temp);
        combination(arr, i + 1, target - arr[i], result, temp);
        temp.pop_back();
        combination(arr, i + 1, target, result, temp);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> temp;
        combination(candidates, 0, target, result, temp);
        return result;
    }
};