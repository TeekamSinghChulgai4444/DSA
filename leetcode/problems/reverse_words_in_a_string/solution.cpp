class Solution {
public:
    string reverseWords(string s) {
        int l = s.length();
        string ans = "";
        string temp = "";
       

        int i = 0;

        while (i < l) {
            if (s[i] != ' ') {
                temp += s[i];
            }
            if(s[i] == ' ' && temp.length()>0 ){
                if(ans.length()>0){
                    temp=temp+" ";
                }
                temp+=ans;
                ans=temp;
                temp="";
            }
            if(i==l-1 && temp.length()>0 ){
                if(ans.length()>0){
                    temp=temp+" ";
                }
                temp+=ans;
                ans=temp;
                temp="";
            }
            
            i++;
        }

        return ans;
    }
};