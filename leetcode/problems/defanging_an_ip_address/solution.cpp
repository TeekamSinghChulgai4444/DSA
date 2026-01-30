class Solution {
public:
    string defangIPaddr(string address) {
        string answer;

        for (char add : address) {
            if (add == '.') {
                answer = answer + '[' + '.' + ']';
            } else {
                answer += add;
            }
        }

        return answer;
    }
};