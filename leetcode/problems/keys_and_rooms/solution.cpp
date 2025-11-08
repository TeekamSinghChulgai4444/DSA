class Solution {
public:

    void  helper(vector<vector<int>>&rooms,vector<bool>&visited,int curr,int total){
        if(curr>=total || visited[curr] == true ){
            return;
        }
        visited[curr]=true;
        vector<int>temp=rooms[curr];
        for(int val:temp){
            helper(rooms,visited,val,total);
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int total=rooms.size();
        vector<bool>visited(total,false);
        int curr=0;
        helper(rooms,visited,curr,total);

        for(bool ans: visited){
            if(ans==false){
                return false;
            }
        }
        return true;
        
    }
};