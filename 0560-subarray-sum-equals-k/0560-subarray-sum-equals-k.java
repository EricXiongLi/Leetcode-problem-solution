class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//sum -> frequency
        map.put(0, 1);
        int curSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        
        return res;
    }
}