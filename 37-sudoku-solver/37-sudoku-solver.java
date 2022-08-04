class Solution {
    public void solveSudoku(char[][] board) {
        int[][] rowUsed = new int[9][10];
        int[][] colUsed = new int[9][10];
        int[][] boxUsed = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int box = 3 * (i / 3) + j / 3;
                    int num = board[i][j] - '0';
                    colUsed[j][num] = 1;
                    rowUsed[i][num] = 1;
                    boxUsed[box][num] = 1;
                }
            }
        }
        dfs(0, 0, rowUsed, colUsed, boxUsed, board);
        return;
    }
    
    private boolean dfs(int row, int col, int[][] rowUsed, int[][] colUsed, int[][] boxUsed, char[][] board) {
        if (row == 9) {
            return true;
        }
        int box = col / 3 + (row / 3) * 3; 
        int nc = (col + 1) % 9;
        int nr = nc == 0 ? row + 1 : row;
        if (board[row][col] != '.') {
            return dfs(nr, nc, rowUsed, colUsed, boxUsed, board);
        }
        
        for (int i = 1; i <= 9; i++) {
            if (rowUsed[row][i] == 0 && colUsed[col][i] == 0 && boxUsed[box][i] == 0) {
                rowUsed[row][i] = 1;
                colUsed[col][i] = 1;
                boxUsed[box][i] = 1;
                board[row][col] = (char)('0' + i);
                if (dfs(nr, nc, rowUsed, colUsed, boxUsed, board)) {
                    return true;
                }
                rowUsed[row][i] = 0;
                colUsed[col][i] = 0;
                boxUsed[box][i] = 0;
                board[row][col] = '.';
            }
        }
        return false;
    }
}