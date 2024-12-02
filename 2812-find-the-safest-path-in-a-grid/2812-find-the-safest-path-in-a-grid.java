class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] distance = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        for (int[] arr : distance) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                    distance[r][c] = 0;
                }
            }
        }
        
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            step++;
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int neiR = cur[0] + dir[0];
                    int neiC = cur[1] + dir[1];
                    if (neiR >= 0 && neiR < m && neiC >= 0 && neiC < n && !visited[neiR][neiC]) {
                        distance[neiR][neiC] = step;
                        visited[neiR][neiC] = true;
                        q.offer(new int[]{neiR, neiC});
                    }
                }
            }
        }
        
        //[r, c, distance]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        visited = new boolean[m][n];
        maxHeap.offer(new int[]{0, 0, distance[0][0]});
        visited[0][0] = true;
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return cur[2];
            }
            for (int[] dir : dirs) {
                int neiR = cur[0] + dir[0];
                int neiC = cur[1] + dir[1];
                
                if (neiR >= 0 && neiR < m && neiC >= 0 && neiC < n && !visited[neiR][neiC]) {
                    
                    visited[neiR][neiC] = true;
                    int newDist = Math.min(cur[2], distance[neiR][neiC]);
                   
                    maxHeap.offer(new int[]{neiR, neiC, newDist});
                }
            }
        }
        
        return -1;
        
    }
}