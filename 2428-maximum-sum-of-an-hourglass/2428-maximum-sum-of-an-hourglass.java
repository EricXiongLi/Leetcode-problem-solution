class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] area = new int[m + 1][n + 1];
        //area[i][j] = area[i - 1][j] + area[i][j - 1] - area[i][j] + grid[i][j];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                area[i + 1][j + 1] = area[i][j + 1] + area[i + 1][j] - area[i][j] + grid[i][j];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                int curSum = area[i + 1][j + 1] - area[i - 2][j + 1] - area[i + 1][j - 2] + area[i - 2][j - 2] - grid[i - 1][j] - grid[i - 1][j - 2];
                res = Math.max(res, curSum);
            }
        }
        
        return res;
    }
}

// tc: O(m * n)
//sc: O(m * n)
    