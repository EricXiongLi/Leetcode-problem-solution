class Solution {
    public void rotate(int[][] matrix) {
        //n = 3, row = 1, col = 0
        //n = 4, row = 1, col = 1
        int n = matrix[0].length;
        for (int row = 0; row <= (n - 1)/2; row++) {
            for (int col = 0; col <= n/2 - 1; col++) {
                //p0: row, col
                //p1: col, n - 1 - row
                //p2: n - 1 - row, n - 1 - col
                //p3: n - 1 - col, row
                //int tmp = p0;
                //p0 = p3;
                //p3 = p2
                //p2 = p1
                //p1 = tmp

                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = tmp;
            }
        }
    }
}