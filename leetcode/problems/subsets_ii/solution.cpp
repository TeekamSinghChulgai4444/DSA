class Solution {
public:
    void subset(vector<int>& nums, int index, vector<vector<int>>& result, vector<int>& temp) {
        result.push_back(temp);
        for (int i = index; i < nums.size(); ++i) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            temp.push_back(nums[i]);
            subset(nums, i + 1, result, temp);
            temp.pop_back();
        }
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> temp;
        sort(nums.begin(), nums.end());
        subset(nums, 0, result, temp);
        return result;
    }
};