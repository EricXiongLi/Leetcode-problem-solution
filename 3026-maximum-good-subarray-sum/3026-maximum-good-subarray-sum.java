class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long res = Long.MIN_VALUE;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            //num1 - nums2 = +-k
            int target1 = nums[i] + k;
            int target2 = nums[i] - k;
            int pos1 = map.getOrDefault(target1, -1);
            int pos2 = map.getOrDefault(target2, -1);
            if (pos1 != -1) {
                res = Math.max(prefixSum[i + 1] - prefixSum[pos1], res);
            }

            if (pos2 != - 1) {
                res = Math.max(prefixSum[i + 1] - prefixSum[pos2], res);
            }

            if (map.containsKey(nums[i])) {
                int old = map.get(nums[i]);
                //sum [old, old + 1, old + 2, i - 1] < 0
                if (prefixSum[i] - prefixSum[old] < 0L) {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return res == Long.MIN_VALUE ? 0 : res;
    }
}