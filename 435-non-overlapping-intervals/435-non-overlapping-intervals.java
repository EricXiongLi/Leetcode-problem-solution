class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int removed = 0;
        int end = Integer.MIN_VALUE;
        for (int[] cur : intervals) {
            if (cur[0] >= end) end = cur[1];
            else removed++;
        }
        return removed;
    }
}