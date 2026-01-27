class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int i=0;

        for( string abc : operations){
            if(abc=="++X"){
                i++;
            }
            else if( abc=="X++"){
                i++;
            }
            else{
                i--;
            }
        }
        return i;
        
    }
};