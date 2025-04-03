class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return slow;
            }
        }

        
    }
}