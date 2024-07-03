class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}