class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int N;
    public TicTacToe(int n) {
        N = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        int cur = (player == 1) ? 1 : -1;
        rows[row] += cur;
        cols[col] += cur;
        if (row == col) {
            diagonal += cur;
        }
        if (row + col + 1 == N) {
            antiDiagonal += cur;
        }
        
        if (rows[row] == cur * N || cols[col] == cur * N || diagonal == cur * N || antiDiagonal == cur * N) {
            return cur == 1 ? 1 : 2;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */