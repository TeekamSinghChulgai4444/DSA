class Solution {
public:
    bool uniformArray(vector<int>& nums1) {
        int n= nums1.size();

      vector<int>ans=nums1;
        int even=0;
        int odd=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        if(even==0 || odd==0){
            return true;
        }
        sort(nums1.begin(),nums1.end());
        for(int i=0;i<n;i++){
            
            if(i==0){
                if(nums1[i] %2==0){
                    return false;
                }
                continue;
            }
            if(nums1[i] %2==0){
                if(nums1[i-1]>=nums1[i] || nums1[i-1] %2 ==0 ){
                    return false;
                }
                nums1[i]=nums1[i]-nums1[i-1];
            }
        }
        return true;
    }
};