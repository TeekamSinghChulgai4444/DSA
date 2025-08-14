class MinStack {
public:
    long long int min;
    stack<long long int> st;

    MinStack() {
        min = 0;
    }

    void push(int val) {
        if (st.empty()) {
            st.push(val);
            min = val;
        } else {
            if (val < min) {
                st.push(2LL * val - min);  // Encode previous min
                min = val;
            } else {
                st.push(val);
            }
        }
    }

    void pop() {
        if (st.empty()) return;

        long long int topVal = st.top();
        st.pop();

        if (topVal < min) {
            min = 2LL * min - topVal;  // Decode previous min
        }
    }

    int top() {
        if (st.empty()) return -1;

        long long int topVal = st.top();
        if (topVal < min) {
            return min;  // Encoded value, actual top is min
        } else {
            return topVal;
        }
    }

    int getMin() {
        return min;
    }
};