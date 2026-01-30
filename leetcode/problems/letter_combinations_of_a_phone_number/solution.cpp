class Solution {
public:

    void recursion(vector<string>&ans, vector<string>data,int i ,string val,vector<char>temp){

            if(i == val.size()){
                string abc;
                for(char ch : temp){
                    abc+=ch;
                }
                ans.push_back(abc);
                return;
            }

            int index=val[i]-'0';
            string  str=data[index];

            for(char ch : str){
                temp.push_back(ch);
                recursion(ans,data,i+1,val,temp);
                temp.pop_back();
            }

          return;

    }
    
    vector<string> letterCombinations(string digits) {

        vector<string>data={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        vector<string>ans;
        vector<char>temp;

        recursion(ans,data,0,digits,temp);
        return ans;
        
    }
};