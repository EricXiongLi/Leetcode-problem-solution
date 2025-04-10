class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) candidate = num;
            votes += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}