class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();
        
        int l=nums.length;

        for(int i=0;i<l;i++){

            if(mp.containsKey(nums[i])){
                    int val=mp.get(nums[i]);
                    if(Math.abs(i-val) <= k){
                        return true;
                    }
                    
             }
                mp.put(nums[i],i);
           

        }
        return false;
        
    }
}