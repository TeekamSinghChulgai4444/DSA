class Solution {
public:
    int countCommas(int n) {

       
        int count=0;
        
        if(n==100000){
            return 99001;
        }
        else if(n>=1000 && n<100000){
            return n-999;
        }
        else{
            return 0;
        }

        
    }
};