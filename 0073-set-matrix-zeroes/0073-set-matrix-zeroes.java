class Solution {
    public void setZeroes(int[][] matrix) {
        int firstRow = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (row == 0) {
                    if (firstRow == 0 || matrix[0][col] == 0) {
                        matrix[row][col] = 0;
                    }
                } else {
                    if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                        matrix[row][col] = 0;
                    }
                }
            }
        }
        for (int row = 0; row < m; row++) {
            if (matrix[0][0] == 0) {
                matrix[row][0] = 0;
            }
        }
        for (int col = 0; col < n; col++) {
            if (firstRow == 0) {
                matrix[0][col] = 0;
            }
        }
        
        
    }
}