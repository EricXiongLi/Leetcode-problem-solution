class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                int curDiff = Math.abs(sum - target);
                if (curDiff < diff) {
                    res = sum;
                    diff = curDiff;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}

//tc: O(nlogn)
//sc: O(1)