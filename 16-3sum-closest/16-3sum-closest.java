class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int closestSum = twoSumClosest(nums, i + 1, target - nums[i]);
            if (Math.abs(closestSum + nums[i] - target) < Math.abs(diff)) {
                res = closestSum + nums[i];
                diff = res - target;
            }
        }
        return res;
    }
    
    //1, 2, 3, 4
    private int twoSumClosest(int[] nums, int i, int target) {
        int l = i, r = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        while (l < r) {
            int curSum = nums[l] + nums[r];
            if (curSum > target) {
                if (Math.abs(curSum - target) < Math.abs(diff)) {
                    res = curSum;
                    diff = curSum - target;
                }
                r--;
            } else if (curSum < target) {
                if (Math.abs(curSum - target) < Math.abs(res - target)) {
                    res = curSum;
                    diff = curSum - target;
                }
                l++;
            } else {
                return target;
            }
        }
        return res;
    }
}