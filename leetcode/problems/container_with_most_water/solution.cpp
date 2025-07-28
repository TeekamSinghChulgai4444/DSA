class Solution {
public:
    int maxArea(vector<int>& height) {
        int*n1=&height[0];
        int base=height.size()-1;
        int*n2=&height[base];

        int area=0;
        int fix_area=0;
        while(n1 < n2){
            if(*(n2)>=*(n1)){
                area=*(n1)*base;
                n1++;
            } else{
                area=*(n2)*base;
                n2--;
            }
            if(area>fix_area){
                fix_area=area;
            }
            base--;
        }
        return fix_area;
        
    }
};