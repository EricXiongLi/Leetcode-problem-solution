class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean merged = false;
        int prevStart = newInterval[0];
        int prevEnd = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if (curEnd < prevStart) {
                res.add(intervals[i]);
            } else if (curStart > prevEnd) {
                if (!merged) {
                    res.add(new int[]{prevStart, prevEnd});
                    merged = true;
                }
                res.add(intervals[i]);
            } else {
                prevStart = Math.min(prevStart, curStart);
                prevEnd = Math.max(curEnd, prevEnd);
            }
        }
        
        if (!merged) {
            res.add(new int[]{prevStart, prevEnd});
        }
        
        return res.toArray(new int[0][0]);
    }
}