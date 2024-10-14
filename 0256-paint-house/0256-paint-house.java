class Solution {
    public int minCost(int[][] costs) {
        //dp[i][0]: ending with i, with color 0
        //dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
        int prev0 = costs[0][0];
        int prev1 = costs[0][1];
        int prev2 = costs[0][2];
        int cur0 = prev0, cur1 = prev1, cur2 = prev2;
        int n = costs.length;
        
        for (int i = 1; i < n; i++) {
            cur0 = Math.min(prev1, prev2) + costs[i][0];
            cur1 = Math.min(prev0, prev2) + costs[i][1];
            cur2 = Math.min(prev0, prev1) + costs[i][2];
            prev0 = cur0;
            prev1 = cur1;
            prev2 = cur2;
        }
        
        return Math.min(Math.min(cur0, cur1), cur2);
        
    }
}