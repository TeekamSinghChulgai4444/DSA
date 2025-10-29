class Solution {
public:

    void merge(vector<int>&nums,int st,int mid,int  end){
        vector<int>ans;
        int i=st;
        int j=mid+1;

        while(i<=mid && j<=end){
            if(nums[i]>nums[j]){
                ans.push_back(nums[j]);
                j++;
            }else{
                ans.push_back(nums[i++]);
            }
        }

        while(i<=mid){
            ans.push_back(nums[i++]);
        }

        while(j<=end){
            ans.push_back(nums[j++]);
        }

        for(int k=0;k<ans.size();k++){
            nums[k+st]=ans[k];
        }
    }
    void helper(vector<int>&nums,int st,int end){

        if(st<end){
        int mid = st + (end - st) / 2;
        helper(nums,st,mid);
        helper(nums,mid+1,end);
        merge(nums,st,mid,end);
        }

    }
    vector<int> sortArray(vector<int>& nums) {
            int st=0;
            int end=nums.size()-1;
            helper(nums,st,end);
            return nums;
        
    }
};