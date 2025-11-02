class Solution {
public:
    long long removeZeros(long long n) {
        string ans=to_string(n);
        int i=0;
        long long temp=0;

        while(ans[i]!= '\0'){
            if(ans[i] != '0'){
                temp=ans[i]-'0'+temp*10;
            }
            i++;
        }
        return temp;
        
    }
};