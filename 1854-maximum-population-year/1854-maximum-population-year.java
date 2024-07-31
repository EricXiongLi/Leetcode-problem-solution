class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> list = new ArrayList();
        for (int[] log : logs) {
            list.add(new int[]{log[0], 1});
            list.add(new int[]{log[1], -1});
        }
        
        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int res = -1;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int[] item : list) {
            cur += item[1];
            if (cur > max) {
                res = item[0];
                max = cur;
            }
        }
        
        return res;
    }
}