class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n= nums.size();
        vector<int>posative;
        vector<int>negative;

        for(int i=0;i<n;i++){
            if(nums[i]<0){
                negative.push_back(nums[i]);
            }else{
                posative.push_back(nums[i]);
            }
    
        }
         
         vector<int>ans;

         int j=0;
         int k=0;
         int m=n/2;

         while(j<m){
            ans.push_back(posative[j]);
            ans.push_back(negative[k]);
            j++;
            k++;
        }
     return ans;
        
    }
};