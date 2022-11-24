class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!dq.isEmpty() && nums[i] > dq.peek()) {
                k = Math.max(dq.poll(), k);
            }
            dq.push(nums[i]);
        }
        return false;
    }
}