class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && nums[i % n] >= dq.peek()) {
                dq.pop();
            }
            if (i < n) res[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(nums[i % n]);
        }
        return res;
    }
}