class Solution {
    public long largestEvenSum(int[] nums, int k) {
        //[5, 4, 3, 1, 1]
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        for (int i = n - k; i < n; i++) {
            sum +=nums[i];
        }
        if (sum % 2 == 0) return sum;
        long minOdd = 1000000L;
        long minEven = 1000000L;
        for (int i = n - k; i < n; i++) {
            if (nums[i] % 2 == 0) {
                minEven = Math.min(minEven, nums[i]);
            } else {
                minOdd = Math.min(minOdd, nums[i]);
            }
        }
        long res = -1;
        
        for (int i = n - k - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                if (minOdd != 1000000) {
                    res = Math.max(res, sum - minOdd + nums[i]);
                }
            } else {
                if (minEven != 1000000) {
                    res = Math.max(res, sum - minEven + nums[i]);
                }
            }
            
        }
        return res;
    }
}