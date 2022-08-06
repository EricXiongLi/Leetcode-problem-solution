class Solution {
    //the numver of subarray where there is at most k odd numbers - the number of subarray there is at most k odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    public int atMost(int[] nums, int k) {
        int left = 0, res = 0;
        int oddCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (curNum % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                int leftNum = nums[left];
                if (leftNum % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}