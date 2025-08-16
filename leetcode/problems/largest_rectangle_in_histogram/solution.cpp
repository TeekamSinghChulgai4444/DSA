class Solution {
public:

   void get_prev(vector<int>heights, vector<int>&left, int n){
          stack<int>st;
          for(int j = 0; j < n; j++){
              while(!st.empty() && heights[st.top()] >= heights[j]){
                  st.pop();
              }
              if(!st.empty()){
                  left.push_back(st.top());
              } else {
                  left.push_back(-1);
      
              }
      
              st.push(j);
          }   
    }  

    void get_right(vector<int>heights, vector<int>&right, int n){
        stack<int>st;
        for(int j = n-1; j >= 0; j--){
            while(!st.empty() && heights[st.top()] >= heights[j]){
                st.pop();
            }
            if(!st.empty()){
                right.push_back(st.top());
            } else {
                right.push_back(-1);
            }
    
            st.push(j);
        }   
        reverse(right.begin(), right.end());
    }


   void highest_area(vector<int>heights, vector<int>&left,vector<int>right, int n, int & area){
       int smallarea = 0;
       for(int j = 0; j < n; j++){
          
           if(right[j] == -1){
               right[j] = n;
           }
           int width = right[j] - left[j] - 1;
           smallarea = heights[j] * width;
           if(smallarea > area){
               area = smallarea;
           }
        }
    }

    int largestRectangleArea(vector<int>& heights) {
        vector<int>right;
        vector<int>left;
        int n=heights.size();
        int area=0;

        get_prev(heights,left,n);
        get_right(heights,right,n);
        highest_area(heights,left,right,n,area);
        return area;
    }
};