class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];
            if (curStart > prevEnd) {
                res.add(new int[]{prevStart, prevEnd});
                prevStart = curStart;
                prevEnd = curEnd;
            } else {
                prevEnd = Math.max(prevEnd, curEnd);
            }
        }
        res.add(new int[]{prevStart, prevEnd});
        
        return res.toArray(new int[0][0]);
    }
}