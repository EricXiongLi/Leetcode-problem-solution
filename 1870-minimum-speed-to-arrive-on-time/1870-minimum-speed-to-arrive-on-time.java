class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
         int max = (int)1e7;
        int l = 1, r = max;
        while (l <= r) {
            int m = l + r >> 1;
            if (isPossible(dist, m, hour)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l > max ? -1 : l;
    }
    
    public boolean isPossible(int[] dist, int m, double hour) {
        double res = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            res += (dist[i] + m - 1) / m;
        }
        res += dist[n - 1] / (double)m;
        System.out.println(m + ":" + res);
        return res <= hour;
    }
}
//tc: O(nlogn)
//sc: O(1)