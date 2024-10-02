class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        //dp[i][0] = Math.min(dp[i-1][0] + regular[i], dp[i - 1][1] + regular[i], dp[i - 1][1] + express[i])
        //dp[i][1] = Math.min(dp[i - 1][1] + express[i], dp[i - 1][0] + expressCost + express[i], dp[i - 1][0] + regular[i] + expressCost);
        int n = regular.length;
        long[] dp = new long[2];
        long[] prevDp = new long[2];
        prevDp[1] = expressCost;
        long[] res = new long[n];
        
        for (int i = 0; i < n; i++) {
            dp[0] = Math.min(Math.min(prevDp[0] + regular[i], prevDp[1] + regular[i]), prevDp[1] + express[i]);
            dp[1] = Math.min(Math.min(prevDp[1] + express[i], prevDp[0] + expressCost + express[i]), prevDp[0] + regular[i] + expressCost);
            res[i] = Math.min(dp[0], dp[1]);
            prevDp[0] = dp[0];
            prevDp[1] = dp[1];
        }
        
        return res;
    }
}

//tc: O(n)
//sc: O(1)