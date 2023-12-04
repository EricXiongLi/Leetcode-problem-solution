class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            int start = arr[0], end = arr[1];
            list.add(new int[]{start, 1});
            list.add(new int[]{end, -1});
        }
        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int res = 0, count = 0;
        for (int[] arr : list) {
            count += arr[1];
            res = Math.max(res, count);
        }
        return res;
    }
}