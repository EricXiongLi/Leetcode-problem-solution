class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, res = Integer.MIN_VALUE;
        Deque<Integer> minD = new ArrayDeque<>(), maxD = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!maxD.isEmpty() && maxD.peekLast() < nums[i]) {
                maxD.pollLast();
            }
            maxD.offer(nums[i]);
            while (!minD.isEmpty() && nums[i] < minD.peekLast()) {
                minD.pollLast();
            }
            minD.offer(nums[i]);
            while ( maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peek() == nums[left]) maxD.poll();
                if (minD.peek() == nums[left]) minD.poll();
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}