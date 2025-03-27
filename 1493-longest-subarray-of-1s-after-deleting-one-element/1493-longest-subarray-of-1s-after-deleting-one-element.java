class Solution {
    public int longestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.getOrDefault(0, 0) > 1) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }
            res = Math.max(r - l, res);
        }

        return res;
    }
}