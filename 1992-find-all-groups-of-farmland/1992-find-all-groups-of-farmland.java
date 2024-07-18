class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> res = new ArrayList();
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        //0: not visited yet
        //1: already visited
        int[][] visited = new int[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (land[row][col] == 1 && visited[row][col] == 0) {
                    int endingRow = row;
                    int endingCol = col;
                    q.offer(new Pair(row, col));
                    visited[row][col] = 1;
                    //visit neighbor
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> cur = q.poll();
                        
                        for (int[] dir : dirs) {
                            int neiRow = cur.getKey() + dir[0];
                            int neiCol = cur.getValue() + dir[1];
                            if (isWithinGrid(neiRow, neiCol, m, n) && land[neiRow][neiCol] == 1 && visited[neiRow][neiCol] == 0) {
                                q.offer(new Pair(neiRow, neiCol));
                                visited[neiRow][neiCol] = 1;
                                endingRow = Math.max(neiRow, endingRow);
                                endingCol = Math.max(neiCol, endingCol);
                            }
                        }
                    }
                    res.add(new int[]{row, col, endingRow, endingCol});
                }
            }
        }
        
        return res.stream().toArray(int[][]::new);
    }
    
    private boolean isWithinGrid(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}