class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isDiagonal(m, n, r, c) && grid[r][c]  == 0) {
                    return false;
                } else if (!isDiagonal(m, n, r, c) && grid[r][c] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isDiagonal(int m, int n, int r, int c) {
        return r == c || r + c + 1 == n;
    }
}