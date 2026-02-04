class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int maxx=0;

        for(int i=0;i<n;i++){
            if( maxx <i ){
                return false;
            }
            int temp=nums[i]+i;

            maxx=max(temp,maxx);
        }
        return true;
        
    }
};