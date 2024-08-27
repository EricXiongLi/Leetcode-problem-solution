class Solution {
    
    
    public int minIncrementForUnique(int[] nums) {
       Map<Integer, Integer> count = new HashMap();
        int min = 100000;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            min = Math.min(nums[i], min);
        }
        int res = 0;
        for (int i = min; i <= 200000; i++) {
            if (count.getOrDefault(i, 0) > 1) {
                int toMove = count.get(i) - 1;
                res += toMove;
                count.put(i + 1, count.getOrDefault(i + 1, 0) + toMove);
            }
        }
        
        return res;
    }
    
    
}