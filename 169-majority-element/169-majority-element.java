class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -10000, count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}