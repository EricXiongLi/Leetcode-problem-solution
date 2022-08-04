class Solution {
    public void solveSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowUsed = new HashMap<>();
        Map<Integer, Set<Character>> colUsed = new HashMap<>();
        Map<Integer, Set<Character>> blockUsed = new HashMap<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                int blockNum = 3 * (row / 3) + col / 3;
                rowUsed.computeIfAbsent(row, v -> new HashSet<Character>()).add(c);
                colUsed.computeIfAbsent(col, v -> new HashSet<Character>()).add(c);
                blockUsed.computeIfAbsent(blockNum, v -> new HashSet<Character>()).add(c);
            }
        }
        dfs(board, 0, 0, rowUsed, colUsed, blockUsed);
        return;
    }
    
    public boolean dfs(char[][] board, int row, int col, Map<Integer, Set<Character>> rowUsed, Map<Integer, Set<Character>> colUsed, Map<Integer, Set<Character>> blockUsed) {
        //ending case
        if (row == 9 && col == 0) {
            return true;
        }
        if (board[row][col] != '.') {
            if (col == 8) {
                if (dfs(board, row + 1, 0, rowUsed, colUsed, blockUsed)) return true;
            } else {
               if (dfs(board, row, col + 1, rowUsed, colUsed, blockUsed)) return true;
            }
        } else {
            for (char c = '1'; c <= '9'; c++) {
                int blockNum = (row / 3) * 3 + col / 3;
                if (rowUsed.getOrDefault(row, new HashSet<Character>()).contains(c) || colUsed.getOrDefault(col, new HashSet<Character>()).contains(c) || blockUsed.getOrDefault(blockNum, new HashSet<Character>()).contains(c)) continue;
                board[row][col] = c;
                rowUsed.computeIfAbsent(row, v -> new HashSet<Character>()).add(c);
                colUsed.computeIfAbsent(col, v -> new HashSet<Character>()).add(c);
                blockUsed.computeIfAbsent(blockNum, v -> new HashSet<Character>()).add(c);
                if (col == 8) {
                    if (dfs(board, row + 1, 0, rowUsed, colUsed, blockUsed)) return true;
                } else {
                    if (dfs(board, row, col + 1, rowUsed, colUsed, blockUsed)) return true;
                }
                board[row][col] = '.';
                rowUsed.get(row).remove(c);
                colUsed.get(col).remove(c);
                blockUsed.get(blockNum).remove(c);
            }
        }
        return false;
    }
}