class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        //decreasing queue
        //5, 4, 3 : value
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            int startWindowIndex = i - k + 1;
            // make sure the size < k
            while (!dq.isEmpty() && i - dq.peekFirst() + 1 > k) {
                dq.pollFirst();
            }
            // make sure it;s monotonic
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (startWindowIndex >= 0) {
                res[startWindowIndex] = nums[dq.peekFirst()];
            }
        }
        
        return res;
    }
}