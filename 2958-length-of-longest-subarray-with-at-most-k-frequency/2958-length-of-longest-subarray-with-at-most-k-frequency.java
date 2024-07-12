class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0, n = nums.length;
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap();
        
        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.get(nums[end]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            res = Math.max(end - start + 1, res);
        }
        
        return res;
    }
}