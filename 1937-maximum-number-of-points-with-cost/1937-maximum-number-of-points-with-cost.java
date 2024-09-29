class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        //dp[i][j]: the max points when ending at cell points[i][j]
        //dp[i][j] = points[i][j] + max(dp[i - 1][k] + |j-k|)
        //dp[i][j] =
        //case1: points[i][j] + max(dp[i - 1][k] + k - j) : k >= j
        //case2: points[i][j]  + max(dp[i - 1][k] + j - k): k <= j
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        
        for (int r = 1; r < m; r++) {
            
            // 对于所有的上一行元素，他们移到这一行的j处，能折算成的最多的加分
            // For all the elements in the previous row, the maximum bonus points they can get when they move to position j in this row
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            leftMax[0] = dp[0];
            rightMax[n - 1] = dp[n - 1];
            for (int c = 1; c < n; c++) {
                leftMax[c] = Math.max(dp[c], leftMax[c - 1] - 1);
            }
            for (int c = n - 2; c >= 0; c--) {
                rightMax[c] = Math.max(dp[c], rightMax[c + 1] - 1);
            }
            for (int c = 0; c < n; c++) {
                dp[c] = Math.max(rightMax[c], leftMax[c]) + points[r][c];
            }
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}

//tc： O（mn
//sc： O（n）