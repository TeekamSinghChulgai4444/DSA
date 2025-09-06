class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int val=0;
        int freq=0;

     for(int j : nums){
        if(freq==0){
             val=j;
             freq=1;
        }

        else if(j==val){
             freq++;
        }
       
        else{
           freq--;
        }
    }
      
    return val;
    
    }
};