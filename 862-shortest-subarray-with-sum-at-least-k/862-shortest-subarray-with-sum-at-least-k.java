class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        // deque.offer(0);
        for (int i = 0; i <= nums.length; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.peek()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}