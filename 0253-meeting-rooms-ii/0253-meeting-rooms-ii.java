class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }

        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int res = 0;
        int count = 0;

        for (int[] item : list) {
            count += item[1];
            res = Math.max(res, count);
        }

        return res;
    }
}