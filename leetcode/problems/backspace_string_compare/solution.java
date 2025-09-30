class Solution {
    Stack<Character> check(String s) {
        Stack<Character> s1 = new Stack<>();
        int i = 0;
        int l = s.length();
        while (i < l) {
            char ch = s.charAt(i);
            if (ch == '#' && !s1.isEmpty()) {
                s1.pop();
            } else if (ch != '#') {
                s1.push(ch);
            }
            i++;
        }
        return s1;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = check(s);
        Stack<Character> s2 = check(t);
        return s1.equals(s2);
    }
}