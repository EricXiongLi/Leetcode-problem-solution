class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //[2, 3], [1, 3],
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        
        int count = 0;
        int n = intervals.length;
        if (n == 0) {
            return 0;
        } else {
            int prevStart = intervals[0][0];
            int prevEnd = intervals[0][1];
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < prevEnd) {
                    count++;
                } else {
                    prevEnd = intervals[i][1];
                }
            }
        }
        
        return count;
    }
}