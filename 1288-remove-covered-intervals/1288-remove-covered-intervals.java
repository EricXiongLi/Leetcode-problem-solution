class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int end = Integer.MIN_VALUE;
        int remaining = 0;
        for (int[] cur : intervals) {
            if (cur[1] <= end) continue;
            else {
                end = cur[1];
                remaining++;
            }
        }
        return remaining;
    }
}