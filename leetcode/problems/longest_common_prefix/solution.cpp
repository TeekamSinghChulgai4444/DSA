class Solution {
public:
    void sol(string & ans, string cmp){
        int i=0;
        string anss;
        while(i<ans.length() && i<cmp.length()){
            if(ans[i]==cmp[i]){
                anss=anss+ans[i];
                i++;
            }
            else{
                ans=anss;
                return;
            }
        }
        ans=anss;
        return;
    }
    string longestCommonPrefix(vector<string>& strs) {
        int l=strs.size();
        string ans=strs[0];

        for(int i=1;i<l;i++){
            sol(ans,strs[i]);
        }
        return ans;

        
    }
};