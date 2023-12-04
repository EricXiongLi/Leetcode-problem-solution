class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curStart < prevEnd) {
                return false;
            }
            prevStart = curStart;
            prevEnd = curEnd;
        }
        return true;
    }
}

//tc: O(nlogn)
