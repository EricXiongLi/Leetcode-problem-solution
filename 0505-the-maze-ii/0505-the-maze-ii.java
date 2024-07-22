class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] arr : distance) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        q.offer(new Pair(start[0], start[1]));
        
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            for (int[] dir : dirs) {
                int neiRow = cur.getKey(), neiCol = cur.getValue();
                
                int count = 0;
                while (neiRow + dir[0] >= 0 && neiRow + dir[0] < m && neiCol + dir[1] >= 0 && neiCol + dir[1] < n && maze[neiRow + dir[0]][neiCol + dir[1]] == 0) {
                    neiRow += dir[0];
                    neiCol += dir[1];
                    count++;
                }
                
                if (distance[cur.getKey()][cur.getValue()] + count < distance[neiRow][neiCol]) {
                    distance[neiRow][neiCol] = distance[cur.getKey()][cur.getValue()] + count;
                    if (neiRow == destination[0] && neiCol == destination[1]) continue;
                    q.offer(new Pair(neiRow, neiCol));
                }
            }
        }
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}

//tc: O(mn * max(m, n))
//sc: O(mn)