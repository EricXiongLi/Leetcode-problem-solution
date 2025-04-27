class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (intervals[m][0] > newInterval[0]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int[][] res = new int[n + 1][2];
        for (int i = 0; i <= r; i++) {
            res[i] = intervals[i];
        }
        res[r + 1] = newInterval;

        for (int i = r + 1; i < n; i++) {
            res[i + 1] = intervals[i];
        }

        //merge the array

        int prevStart = res[0][0];
        int prevEnd = res[0][1];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int start = res[i][0];
            int end = res[i][1];

            if (start > prevEnd) {
                list.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            } else {
                prevEnd = Math.max(prevEnd, end);
            }
        }

        list.add(new int[]{prevStart, prevEnd});

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

        //<=, <=, >
        //l, m,   r
        //        l, r
        //    r
    }
}