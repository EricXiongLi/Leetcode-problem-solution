class TicTacToe {
    int[] rowArr;
    int[] colArr;
    int diagonal;
    int antidiagonal;
    int N;
    public TicTacToe(int n) {
        N = n;
        rowArr = new int[n];
        colArr = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        rowArr[row] += player == 1 ? -1 : 1;
        colArr[col] += player == 1 ? -1 : 1;
        if (row == col) {
            diagonal += player == 1 ? -1 : 1;
        }
        //*, *, *, *
        //*, *, *, *
        //*, *, *, *
        //*, *, *, *
        if (row + col == N - 1) {
            antidiagonal += player == 1 ? -1 : 1;
        }
        if (Math.abs(rowArr[row]) == N || Math.abs(colArr[col]) == N || Math.abs(diagonal) == N || Math.abs(antidiagonal) == N) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */