class Solution {
public:
  int maxDistToClosest(vector<int>& seats) {
    queue<int> q;
    int n = seats.size();

    q.push(-1);

    for (int i = 0; i < n; i++) {
        if (seats[i] == 1) {
            q.push(i);
        }
    }

    q.push(n);

    int ans = 0;

    while (q.size() > 1) {
        int st = q.front();
        q.pop();
        int end = q.front();

        int temp;
        if (st == -1) {
            temp = end;
        } else if (end == n) {
            temp = n - 1 - st;
        } else {
            temp = (end - st) / 2;
        }

        ans = max(ans, temp);
    }

    return ans;
}
};