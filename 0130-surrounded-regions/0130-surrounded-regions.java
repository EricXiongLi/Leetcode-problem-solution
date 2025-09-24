class Solution {
    public void solve(char[][] board) {
        //'0' in the border
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                queue.offer(new int[]{r, 0});
                visited[r][0] = true;
            }

            if (board[r][n - 1] == 'O') {
                queue.offer(new int[]{r, n - 1});
                visited[r][n - 1] = true;
            }
        }

        for (int c = 1; c < n - 1; c++) {
            if (board[0][c] == 'O') {
                queue.offer(new int[]{0, c});
                visited[0][c] = true;
            }
            if (board[m - 1][c] == 'O') {
                queue.offer(new int[]{m - 1, c});
                visited[m - 1][c] = true;
            }
        }
        
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] isGood = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int newRow = dir[0] +cur[0], newCol = cur[1] + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O' && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                    isGood[newRow][newCol] = true;
                }
            }
        }

        for (int row = 1; row < m - 1; row++) {
            for (int col = 1; col < n - 1; col++) {
                if (board[row][col] == 'O' && !isGood[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }

        
    }
}