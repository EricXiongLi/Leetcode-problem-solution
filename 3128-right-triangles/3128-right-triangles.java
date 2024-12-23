class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                rowSum[r] += grid[r][c];
                colSum[c] += grid[r][c];
            }
        }
        long res = 0L;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    if (rowSum[r] > 1 && colSum[c] > 1) {
                        res += (rowSum[r] - 1) * (colSum[c] - 1);
                    }
                }
            }
        }

        return res;
        
    }
}