class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp=x;
        int rem=0;
        long long output=0;
        while(x!=0){
            rem=x%10;
          
            if(output>=INT_MAX && output<=INT_MIN){
                return false;
            }
            output=rem+output*10;
            x=x/10;
        }
        if ( int(output) == temp){
            return true;
        }else{
            return false;
        }
        
    }
};