class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        List<Long> list = new ArrayList();
        for (int q : queries) {
            int lower = lowerBound(nums, q);
            long res = 0;
            res += (long) (lower - 0 + 1) * q - sum[lower + 1];
            res += sum[n] - sum[lower + 1] - (long) (n - 1 - lower) * q;
            list.add(res);
        }
        
        return list;
    }
    
    public int lowerBound(int[] nums, int q) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + r >> 1;
            if (nums[m] <= q) {
                l = m + 1;
            } else {
               r = m - 1; 
            }
        }
        
        return r;
    }
}