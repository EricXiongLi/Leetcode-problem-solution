class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        List<int[]> res = new LinkedList<>();
        m = board.length;
        n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c =0; c < n; c++) {
                if (board[r][c] == word.charAt(0)) {
                    res.add(new int[]{r, c});
                }
            }
        }

        for (int[] num: res) {
            if (backtracking(board, word, 1, num[0], num[1], new boolean[m][n])) {
                return true;
            }
        }

        return false;
    }

    public boolean backtracking(char[][] board, String word, int i, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        if (i == word.length()) {
            return true;
        }

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC] && word.charAt(i) == board[newR][newC]) {
                
                if (backtracking(board, word, i + 1, newR, newC, visited)) {
                    return true;
                }
            }
        }
        visited[r][c] = false;
        return false;
    }
}