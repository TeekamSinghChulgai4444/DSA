class Solution {
public:
      
    int trap(vector<int>& height){
    
      int n=height.size();
      int i = 0, j = n - 1;
      int leftmax = 0, rightmax = 0, ans = 0;
    
      while(i < j) {
          if(height[i]>leftmax){
            leftmax=height[i];
          }

          if(rightmax<height[j]){
            rightmax=height[j];
          }

          if(leftmax < rightmax) {
            ans += leftmax - height[i];
            i++;
          } else {
            ans += rightmax - height[j];
            j--;
         }


        }
        return ans;

    }
};