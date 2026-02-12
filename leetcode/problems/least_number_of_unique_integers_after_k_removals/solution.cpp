
class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        int n = arr.size();
        map<int, int> count;
        for (int i = 0; i < n; i++) {
             if(count.find(arr[i]) != count.end()){
                int val = count[arr[i]];
                count[arr[i]] = val + 1;
             }
             else{
                count.insert({arr[i], 1});
             }
        }


        cout << "Before sorting:\n";

    
        vector<pair<int, int>> freq(count.begin(), count.end());
        sort(freq.begin(), freq.end(), [](const pair<int, int>& a, const pair<int, int>& b) { return a.second < b.second; });

        
        int uniqueInts = freq.size();
        for (auto &p : freq) {
            if (k >= p.second) {
                k -= p.second;
                uniqueInts--;
            } else {
                break;
            }
        }
        return uniqueInts;
    }
};