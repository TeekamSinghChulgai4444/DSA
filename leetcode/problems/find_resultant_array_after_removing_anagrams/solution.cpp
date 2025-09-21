
class Solution {
public:
    bool checkk(string Ab, string pre ){
        string A1=Ab;
        sort(A1.begin(),A1.end());
        sort(pre.begin(),pre.end());
    
        if(pre==A1){
            return false;
        }
        
      return true;
    }

    vector<string> removeAnagrams(vector<string>& words) {
       vector<string>ans;
       string pre ="";
       for( string abc : words){
           if(checkk(abc,pre)){
              ans.push_back(abc);
            }
             pre=abc;
       }
       return ans;
    }
};