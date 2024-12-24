class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            int target = prefixSum[i + 1] - k;
            if (map.containsKey(target)) {
                
                int j = map.get(target);
                res = Math.max(i - j, res);
            }
            if (!map.containsKey(prefixSum[i + 1])) {
                map.put(prefixSum[i + 1], i);
            }
        }

        return res;
    }
}