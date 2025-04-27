class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> res = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] item = intervals[i];
            int start = item[0];
            int end = item[1];

            if (start > prevEnd) {
                res.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            } else {
                prevEnd = Math.max(end, prevEnd);
            }
        }

        res.add(new int[]{prevStart, prevEnd});
        int n = res.size();

        int[][] ans = new int[n][2];

        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}