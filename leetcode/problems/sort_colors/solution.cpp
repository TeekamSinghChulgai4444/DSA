class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int swap=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=swap;
                }
            }
        }

    }
};