class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> res = new LinkedList<>();
        int[] pre = intervals[0];
        for (int[] cur : intervals) {
            if (cur[0] > pre[1]) {
                res.add(pre);
                pre = cur;
            } else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        res.add(pre);
        return res.toArray(new int[0][]);
    }
}