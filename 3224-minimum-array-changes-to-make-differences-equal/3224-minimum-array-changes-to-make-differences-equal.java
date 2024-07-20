class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap();
        
        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(nums[i] - nums[n - 1 - i]);
            count.put(diff, count.getOrDefault(diff, 0) + 1);
        }
        
        int[] prefixSum = new int[k + 1];
        
        for (int i = 0; i < n / 2; i++) {
            int a= nums[i], b = nums[n - 1 - i];
            
            int maxDiff = Math.max(Math.max(a, b), Math.max(k - a, k - b));
            prefixSum[0]++;
            if (maxDiff + 1 <= k) {
                prefixSum[maxDiff + 1]++;
            }
        }
        
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            sum += prefixSum[i];
            res = Math.min(sum - count.getOrDefault(i, 0), res);
        }
        
        return res;
    }
}

//tc: O(n)
//sc: O(k)