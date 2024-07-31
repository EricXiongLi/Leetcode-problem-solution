class Solution {
    public int brightestPosition(int[][] lights) {
        List<int[]> list = new ArrayList();
        for (int[] light : lights) {
            list.add(new int[]{light[0] - light[1], 1});
            list.add(new int[]{light[0] + light[1] + 1, -1});
        }
        
        Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int res = -1;
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

//tc: O(nlogn)
//sc: O(n)