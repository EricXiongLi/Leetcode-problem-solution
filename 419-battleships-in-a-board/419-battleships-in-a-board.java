class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - 1 < 0 || (i - 1 >= 0 && board[i - 1][j] != 'X')) && (j - 1 < 0 || (j - 1 >= 0 && board[i][j - 1] != 'X')) && board[i][j] == 'X') {
                    res++;
                }
            }
        }
        return res;
    }
}