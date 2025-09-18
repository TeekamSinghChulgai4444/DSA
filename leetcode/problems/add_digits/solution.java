class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int ans=0;
        int rem=0;
        while( num != 0 || ans >= 10 ){
            if(num==0){
                num=ans;
                ans=0;
            }
            rem=num%10;
            ans+=rem;
            num/=10;
        }

        return ans;
        
    }
}