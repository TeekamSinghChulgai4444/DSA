class Solution {
public:
void find (vector<int>&nums,vector<vector<int>>&result,int index){
    if(index==nums.size()){
        result.push_back(nums);
        return;
    }
    for(int i=index;i<nums.size();i++){
        swap(nums[i],nums[index]);
        find(nums,result,index+1);
        swap(nums[i],nums[index]);
    }
}
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>>result;
        int index=0;
        int n=nums.size();
        find(nums,result,index);
        return result;
        
    }
};