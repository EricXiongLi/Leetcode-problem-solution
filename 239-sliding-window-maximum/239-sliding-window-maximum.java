class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); // 放的是index， 因为需要判断当前窗口是否已经等于k了
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //ensure the size of window
            while (!deque.isEmpty() && i - deque.peekFirst() + 1 > k) deque.pollFirst();
            //ensure the queue is in descending order
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
}