class Solution {
public:
    int helper(int x,int y,int z ,  int step1 ,int  step2 ){
        while(x !=z && y != z){
            x=x+step1;
            y=y+step2;
        }
        if(x == y){
            return 0;
        }
        else if(y==z){
            return 2;
        }
        else{
            return 1;
        }
    }

    int findClosest(int x, int y, int z) {
        int ans;
        int step1;
        int step2;
        if(x<z && y<z){
             step1=1;
             step2=1;
            ans=helper(x, y,z,step1,step2);
        }
        else if(x<z && y>z){
             step1=1;
             step2=-1;
            ans=helper(x,y,z,step1,step2);
        }
        else if(x>z && y<z){
             step1=-1;
             step2=1;
            ans=helper(x,y,z,step1,step2);

        }
        else{
                step1=-1;
                step2=-1;
            ans=helper(x,y,z,step1,step2);
        }
        return ans;
    }
};