class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> rp = new HashMap<>();
        
        for (int i : nums) {
            if (rp.containsKey(i)) {
                int value = rp.get(i);
                rp.put(i, value + 1);
            } else {
                rp.put(i, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> e : rp.entrySet()) {
            if (e.getValue() > 1) {
                return true;
            }
        }
        
        return false;
    }
}