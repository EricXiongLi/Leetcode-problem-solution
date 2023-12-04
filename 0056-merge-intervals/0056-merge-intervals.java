class Solution {
    public int[][] merge(int[][] intervals) {
        //1, 3
        // 2    6
                    // 8   10
//                              15  18
        //1     6
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> res = new ArrayList<>();
        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            if (curStart > prevEnd) {
                res.add(new int[]{prevStart, prevEnd});
                prevStart = curStart;
                prevEnd = curEnd;
            } else {
                prevStart = Math.min(prevStart, curStart);
                prevEnd = Math.max(prevEnd, curEnd);
            }
        }
        res.add(new int[]{prevStart, prevEnd});
        return res.toArray(new int[0][0]);
    }
}