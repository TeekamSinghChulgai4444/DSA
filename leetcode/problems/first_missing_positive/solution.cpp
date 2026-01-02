class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int ans=1;
        int pre=0;

        for(int i=0;i<nums.size();i++){
            
            if(nums[i]<=0|| pre== nums[i]){
                continue;
            }   

            if(ans==nums[i]){
                pre=ans;
                ans=ans+1;
                continue;
            }
            
            break;

        }
        return ans;
    }
};
         