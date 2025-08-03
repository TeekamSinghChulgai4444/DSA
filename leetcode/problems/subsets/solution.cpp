class Solution {
public:

  void subset(vector<int>&arr,int n,vector<vector<int>>&result,int i,vector<int>&temp){
    
       if(i>n){
           return ;
       }

       if(i==n){
           result.push_back(temp);
           return;
       }

       if(i<n){
           temp.push_back(arr[i]);
           subset(arr,n,result,i+1,temp);
           temp.pop_back();
           subset(arr,n,result,i+1,temp);
   
        }
       return;
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>result;
        vector<int>temp;
        int n=nums.size();
        int i=0;
        subset(nums,n,result,i,temp);

        return result;
    }

    
};