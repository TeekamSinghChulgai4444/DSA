class Solution {
public:
    string clearDigits(string s) {
        stack<char> st;
        for (char ch : s) {
            if (ch >= '0' && ch <= '9') {
                if (!st.empty()) st.pop(); // Remove previous character
            } else {
                st.push(ch);
            }
        }

        string result;
        while (!st.empty()) {
            result = st.top() + result;
            st.pop();
        }

        return result;
    }
};