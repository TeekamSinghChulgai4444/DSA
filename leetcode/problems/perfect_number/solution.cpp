class Solution {
public:
    bool checkPerfectNumber(int n) {
        if(n<=1){
            return false;
        }
        int i=2;
        int j=n;
        int sum=1;
        while(j>i){
            if(n%i==0){
                j=n/i;
                sum=sum+i+j;
            }
            i++;
        }

        if(sum==n){
            return true;
        }
        return false;

        
    }
};