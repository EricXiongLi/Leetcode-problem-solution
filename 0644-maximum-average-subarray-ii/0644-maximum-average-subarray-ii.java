class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double l = -10000, r = 10000;
        double epsilon = 1e-5;
        
        while (r - l > epsilon) {
            double m = l + (r - l) / 2;
            if (check(nums, k, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    public boolean check(int[] nums, int k, double x) {
        int n = nums.length;
        double[] arr = new double[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - x;
        }
        
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= 0) return true;
        
        double prefixSum = 0;
        double minPrefix = 0;
        
        for (int i = k; i < n; i++) {
            sum += arr[i];
            prefixSum += arr[i - k];
            minPrefix = Math.min(minPrefix, prefixSum);
            
            if (sum - minPrefix >= 0) {
                return true;
            }
        }
        
        return false;
    }
}