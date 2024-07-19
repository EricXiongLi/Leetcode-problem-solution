class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        int m = grid1.length, n = grid1[0].length;
        Set<Pair<Integer, Integer>> visited = new HashSet();
        int count = 0;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid2[row][col] == 1 && grid1[row][col] == 1 && !visited.contains(new Pair(row, col))) {
                    boolean isSub = true;
                    q.offer(new Pair(row, col));
                    visited.add(new Pair(row, col));
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> cur = q.poll();
                        for (int[] dir : dirs) {
                            int neiRow = cur.getKey() + dir[0];
                            int neiCol = cur.getValue() + dir[1];
                            if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && !visited.contains(new Pair(neiRow, neiCol)) && grid2[neiRow][neiCol] == 1) {
                                if (grid1[neiRow][neiCol] == 0) {
                                    isSub = false;
                                }
                                q.offer(new Pair(neiRow, neiCol));
                                visited.add(new Pair(neiRow, neiCol));
                            }
                        }
                    }
                    if (isSub) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}

//tc: O(mn)
//sc: O(mn)