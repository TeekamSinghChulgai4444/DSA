class Solution {
public:
    int countElements(vector<int>& nums,int k) {
        
    sort(nums.begin(),nums.end());
       int n=nums.size();
        int ans=0;
        
        for(int i=0;i<n;i++){            
            int idx=upper_bound(nums.begin(),nums.end(),nums[i])-nums.begin();
            
            int greater=n-idx;           
            if(greater>= k){
                ans++;
            }
        }       
        return ans;
    }
};