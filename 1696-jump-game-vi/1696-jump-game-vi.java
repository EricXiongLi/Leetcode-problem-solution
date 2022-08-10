class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);//[sumEndAtI, index]
        pq.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < i - k) {
                pq.poll();
            }
            if (i == nums.length - 1) res = pq.peek()[0] + nums[i];
            pq.offer(new int[]{pq.peek()[0] + nums[i], i});
        }
        return res;
    }
}