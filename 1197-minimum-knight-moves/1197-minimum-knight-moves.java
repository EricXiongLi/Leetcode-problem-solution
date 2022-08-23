class Solution {
    public int minKnightMoves(int x, int y) {
        x += 300;
        y += 300;
        int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        boolean[][] visited = new boolean[601][601];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{300, 300});
        visited[300][300] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                int curRow = cur[0], curCol = cur[1];
                if (curRow == x && y == curCol) {
                    return level;
                }
                for  (int dir[] : dirs) {
                    int newRow = curRow + dir[0];
                    int newCol = curCol + dir[1];
                    if (newRow >= 0 && newRow <= 600 && newCol >=0 && newCol <= 600 && !visited[newRow][newCol]) {
                        q.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}