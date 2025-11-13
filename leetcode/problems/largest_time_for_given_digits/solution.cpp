class Solution {
public:
    int getMinute(vector<int> arr, int hour) {
        vector<int> time;
        int first = hour % 10;
        int second = hour / 10;

        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == first || arr[i] == second) {
                (first == arr[i]) ? first = 100 : second = 100;
                continue;
            }
            time.push_back(arr[i]);
        }

        int minute1 = (time[0] * 10 + time[1] < 60) ? time[0] * 10 + time[1] : -1;
        int minute2 = (time[1] * 10 + time[0] < 60) ? time[1] * 10 + time[0] : -1;

        return max(minute1, minute2);
    }

    bool check(int hour, int minute) {
        return hour < 24 && hour >= 0 && minute < 60 && minute >= 0;
    }

    void helper(vector<int> arr, int& hour, int& minute, int n, int i, int j) {
        if (j == i) j++;
        if (j < 0 && i < 0) return;
        if (j == n) {
            j = 0;
            i++;
        }
        if (i == n) return;

        int hour1 = (arr[i] * 10 + arr[j] < 24) ? arr[i] * 10 + arr[j] : -1;
        int hour2 = (arr[j] * 10 + arr[i] < 24) ? arr[j] * 10 + arr[i] : -1;
        int hour3 = max(hour1, hour2);

        int minute1 = getMinute(arr, hour3);

        if (check(hour3, minute1)) {
            if (hour < hour3 || (hour == hour3 && minute < minute1)) {
                hour = hour3;
                minute = minute1;
            }
        }

        helper(arr, hour, minute, n, i, j + 1);
    }

    string largestTimeFromDigits(vector<int>& arr) {
        
     
        int hour = 0, minute = 0, j = 0, i = 0;
        int n = arr.size();
        helper(arr, hour, minute, n, i, j);

        vector<int>temp(n,0);

        if(temp==arr){
            return "00:00";
        }

        if (hour == 0 && minute == 0) return "";

        string ans = "";
        ans += (hour < 10 ? "0" : "") + to_string(hour);
        ans += ":";
        ans += (minute < 10 ? "0" : "") + to_string(minute);
        return ans;
    }
};