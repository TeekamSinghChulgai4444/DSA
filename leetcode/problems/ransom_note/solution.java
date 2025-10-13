import java.util.HashMap;
import java.util.Map;

class Solution {

    public static HashMap<Character, Integer> createMap(String s) {
        HashMap<Character, Integer> str2 = new HashMap<>();

        for (Character i : s.toCharArray()) {
            if (str2.containsKey(i)) {
                int val = str2.get(i);
                str2.put(i, val + 1);
            } else {
                str2.put(i, 1);
            }
        }

        return str2;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> str1 = createMap(ransomNote);
        HashMap<Character, Integer> str2 = createMap(magazine);

        for (Map.Entry<Character, Integer> i : str1.entrySet()) {
            if (!str2.containsKey(i.getKey()) || i.getValue() > str2.get(i.getKey())) {
                return false;
            }
        }

        return true;
    }
}