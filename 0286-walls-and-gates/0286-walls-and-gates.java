class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public void wallsAndGates(int[][] rooms) {
       int EMPTY = Integer.MAX_VALUE;
        //pair: <row, col>
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        
        int m = rooms.length, n = rooms[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new Pair(row, col));
                }
            }
        }
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = q.poll();
                for (int[] dir : dirs) {
                    int neiRow = cur.getKey() + dir[0];
                    int neiCol = cur.getValue() + dir[1];
                    if (neiRow < m && neiRow >= 0 && neiCol < n && neiCol >= 0) {
                        if (rooms[neiRow][neiCol] == EMPTY) {
                            rooms[neiRow][neiCol] = level;
                            q.add(new Pair(neiRow, neiCol));
                        }
                    }
                }
            }
            level++;
        }
    }
}

//tc: O(m * n)
//sc: O(m * n)