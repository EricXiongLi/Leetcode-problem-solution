class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        int res = 0;
        int curSum = 0;
        if (map.containsKey(k)) {
            res = Math.max(res, map.get(k) + 1);
        }
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum + k)) {
                res = Math.max(res, map.get(curSum + k) - i);
            }
        }
        return res;
    }
}