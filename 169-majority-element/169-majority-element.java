class Solution {
    public int majorityElement(int[] nums) {
        return findMajority(nums, 0, nums.length - 1);
    }
    
    public int findMajority(int[] nums, int left, int right) {
        if (left == right) return nums[right];
        int mid = left + (right - left) / 2;
        int leftMajor = findMajority(nums, left, mid);
        int rightMajor = findMajority(nums, mid + 1, right);
        if (leftMajor == rightMajor) return leftMajor;
        int leftCount = 0, rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == leftMajor) leftCount++;
            if (nums[i] == rightMajor) rightCount++;
        }
        return leftCount > rightCount ? leftMajor : rightMajor;
    }
}