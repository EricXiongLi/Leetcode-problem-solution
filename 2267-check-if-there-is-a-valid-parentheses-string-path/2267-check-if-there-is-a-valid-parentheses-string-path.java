class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        //dfs(i, j, k): entering this ceil with k '('
        int m = grid.length, n = grid[0].length;
        dp = new Boolean[m][n][m + n];
        return dfs(grid, m, n, 0, 0, 0);
    }
    
    public Boolean dfs(char[][] grid, int m, int n, int i, int j, int k) {
        if (k < 0) {
            return false;
        }
        
        if (i == m || j == n) {
            return false;
        }
        
        
        
        if (grid[i][j] == '(') {
            k++;
        } else {
            k--;
        }
        if (i == m -1 && j == n - 1) {
            return k == 0;
        }
        if (k < 0) {
            return false;
        }
        if (dp[i][j][k] != null) return dp[i][j][k];
        dp[i][j][k] = dfs(grid, m, n, i + 1, j, k) || dfs(grid, m, n, i, j + 1, k);
        return dp[i][j][k];
    }
}

//tc: O(mn(m + n))
//sc: o(mn(m + n))