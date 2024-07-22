class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int getFood(char[][] grid) {
        int step = 0;
        int m = grid.length, n = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        Set<Pair<Integer, Integer>> visited = new HashSet();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '*') {
                    q.offer(new Pair(row, col));
                    visited.add(new Pair(row, col));
                    break;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = q.poll();
                for (int[] dir : dirs) {
                    int neiRow = cur.getKey() + dir[0];
                    int neiCol = cur.getValue() + dir[1];
                    if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n) {
                        if (grid[neiRow][neiCol] == '#') {
                            return step + 1;
                        } else if (grid[neiRow][neiCol] == 'O' && !visited.contains(new Pair(neiRow, neiCol))){
                            q.offer(new Pair(neiRow, neiCol));
                            visited.add(new Pair(neiRow, neiCol));
                        }
                        
                      
                        
                    }
                }
                
            }
            step++;
        }
        
        return -1;
    }
}

//tc: O(m * n)
//sc: O(m * n)