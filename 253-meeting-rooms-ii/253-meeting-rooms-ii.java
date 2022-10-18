class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            list.add(new int[]{start, 1});
            list.add(new int[]{end, -1});
        }
        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int count = 0;
        int res = 0;
        for (int[] l : list) {
            count += l[1];
            res = Math.max(count, res);
        }
        return res;
    }
}