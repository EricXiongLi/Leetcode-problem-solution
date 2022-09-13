class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        //-2, 0, 1, 6
        for (int i = 0; i < nums.length - 2; i++) {
            count += twoSumSmaller(i + 1, nums, target - nums[i]);
        }
        return count;
    }
    
    //1, 2, 3, 4
    private int twoSumSmaller(int i, int[] nums, int target) {
        int count = 0;
        int l = i, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                count += (r - l);
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}