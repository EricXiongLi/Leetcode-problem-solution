class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> list = new ArrayList<>();//[station num, change of num of passengers]
        for (int[] trip : trips) {
            list.add(new int[]{trip[1], 1 * trip[0]});
            list.add(new int[]{trip[2], -1 * trip[0]});
        }
        Collections.sort(list, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int curPass = 0;
        for (int[] arr : list) {
            curPass += arr[1];
            if (curPass > capacity) {
                return false;
            }
        }
        return true;
    }
}