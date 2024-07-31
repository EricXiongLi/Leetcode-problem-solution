class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Arrays.sort(nums);
        
        for (int num : nums) {
            sum += num;
        }
        
        for (int i = n - 1; i >= 2; i--) {
            long left = sum - nums[i];
            if (left > nums[i]) {
                return left + nums[i];
            }
            sum -= nums[i];
        }
        
        return -1;
    }
}

//tc: O(nlogn)
//sc: O(logn)