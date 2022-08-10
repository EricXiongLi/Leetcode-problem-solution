class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peek()[1] < i - k) {
                dq.poll();
            }
            int cur = dq.peek()[0] + nums[i];
            if (i == nums.length - 1) res = cur;
            while (!dq.isEmpty() && dq.peekLast()[0] <= cur) {
                dq.pollLast();
            }
            dq.offer(new int[]{cur, i});
        }
        return res;
    }
}