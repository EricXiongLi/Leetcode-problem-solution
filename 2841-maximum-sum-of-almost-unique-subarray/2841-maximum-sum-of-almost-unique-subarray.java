class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums.get(i - 1);
        }
        
        int start = 0;
        long res = 0L;
        Map<Integer, Integer> freq = new HashMap();
        
        for (int end = 0; end < n; end++) {
            int num = nums.get(end);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            while (end - start + 1 > k) {
                freq.put(nums.get(start), freq.get(nums.get(start)) - 1);
                if (freq.get(nums.get(start)) == 0) {
                    freq.remove(nums.get(start));
                }
                start++;
            }
            
            if (freq.size() >= m) {
                res = Math.max(sum[end + 1] - sum[start], res);
            }
        }
        
        return res;
        
    }
}