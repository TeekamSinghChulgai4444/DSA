class Solution {
public:

    void abd(vector<int>& arr, int add, int n, vector<int>& ans) {
    if (n == -1) {
        if (add > 0) ans.push_back(add);
        reverse(ans.begin(), ans.end());
        return;
    }

    arr[n] += add;
    if (arr[n] == 10) {
        arr[n] = 0;
        ans.push_back(0);
        abd(arr, 1, n - 1, ans);
    } else {
        ans.push_back(arr[n]);
        abd(arr, 0, n - 1, ans);
    }
   }


    vector<int> plusOne(vector<int>& digits) {
        
        vector<int>ans;
        int n=digits.size();
        int add=1;
        abd(digits,add,n-1,ans);
        return ans;
    }
};