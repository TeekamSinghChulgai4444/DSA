class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l=nums.size();
        int m=0;
        for(int i=0;i<l;i++){
            if(nums[m]<nums[i]){
                m=i;
            }
        }
        return m;
    }
};