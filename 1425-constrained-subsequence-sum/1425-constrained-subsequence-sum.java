class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] sum = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty()) {
                int peek = deque.peekFirst();
                sum[i] = sum[peek] >= 0 ? sum[peek] + sum[i] : sum[i];
            }
            while (!deque.isEmpty() && deque.peekFirst() < i + 1 - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] <= sum[i]) {
                deque.pollLast();
            }
            res = Math.max(res, sum[i]);
            deque.offer(i);
        }
        return res;
    }
}