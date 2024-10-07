class Solution {
    //dp[i][j][k]: the probability for cell[i][j], with k moves left
    //dp[i][j][k] = Sum(0.125 * dp[p][q][k - 1]), where p and q is the nextmove inside the chessboard
    double[][][] dp;
    int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k + 1];
        for (double[][] layer : dp) {
            for (double[] arr : layer) {
                Arrays.fill(arr, -1);
            }
        }
        return getProbability(n, k, row, column);
    }
    
    public double getProbability(int n, int k, int r, int c) {
        if (!isInside(r, c, n)) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[r][c][k] != -1) {
            return dp[r][c][k];
        }
        dp[r][c][k] = 0;
        for (int[] dir : dirs) {
            int newR = dir[0] + r;
            int newC = dir[1] + c;
            dp[r][c][k] += 0.125 * getProbability(n, k - 1, newR, newC);
        }
        
        return dp[r][c][k];
    }
    
    public boolean isInside(int r, int c, int n) {
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}

//tc: O(kn ^ 2)
//sc: O(k n^2)