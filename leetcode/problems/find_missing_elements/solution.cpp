class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        vector<int>temp;

        sort(nums.begin(),nums.end());

        int n=nums.size();
        int i=nums[0];
        int j=0;
        while(j<n-1){
           if( j<n && nums[j+1]!= i+1){
               temp.push_back(i+1);
               i=i+1;
           }else{
             i=i+1;
             j++;
           }
        }
       return temp;
        
    }
};