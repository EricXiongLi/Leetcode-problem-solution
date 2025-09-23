class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }

        //if open and close at the same time, prioritize closing
        Collections.sort(list, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int count = 0;
        int res = 0;
        for (int[] usage : list) {
            count += usage[1];
            res = Math.max(res, count);
        }

        return res;
        
    }
}