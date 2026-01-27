class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        int ans=0;
        int temp=0;

        for( string abc : sentences){
            temp=0;
            for(char a : abc){
                if(a ==' '){
                    temp++;
                }
            }
            temp++;
            if(temp>ans){
                ans=temp;
            }
        }
        return ans;        
    }
};