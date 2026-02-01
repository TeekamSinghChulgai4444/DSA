class Solution {
public:
    bool checkSeq(string &num, string a, string b, int pos) {
        int n = num.size();
        while (pos < n) {
            string sum = addStrings(a, b);
            if (pos + sum.size() > n) return false;
            if (num.substr(pos, sum.size()) != sum) return false;
            pos += sum.size();
            a = b;
            b = sum;
        }
        return true;
    }

    string addStrings(string a, string b) {
        string res = "";
        int i = a.size() - 1, j = b.size() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry) {
            int x = i >= 0 ? a[i--] - '0' : 0;
            int y = j >= 0 ? b[j--] - '0' : 0;
            int sum = x + y + carry;
            res = char(sum % 10 + '0') + res;
            carry = sum / 10;
        }
        return res;
    }

    bool isAdditiveNumber(string num) {
        int n = num.size();
        for (int i = 1; i <= n / 2; i++) {
            if (num[0] == '0' && i > 1) break;
            string a = num.substr(0, i);
            for (int j = i + 1; j < n; j++) {
                if (num[i] == '0' && j - i > 1) break;
                string b = num.substr(i, j - i);
                if (checkSeq(num, a, b, j)) return true;
            }
        }
        return false;
    }
};
