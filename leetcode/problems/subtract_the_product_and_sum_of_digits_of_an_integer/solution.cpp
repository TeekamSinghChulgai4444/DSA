class Solution {
public:
    int subtractProductAndSum(int n) {
        int sub=1;
        int sum=0;

        while(n >0){
            int rem=n%10;
            sub*=rem;
            sum+=rem;
            n=n/10;
        }
        return sub-sum;
        
    }
};