class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        //distance from starting point
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        //<dist, [row, col]>
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<Pair<Integer, int[]>>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        dist[0][0] = 0;
        pq.offer(new Pair(0, new int[]{0, 0}));
        while (!pq.isEmpty()) {
            Pair<Integer, int[]> cur = pq.poll();
            int row = cur.getValue()[0], col = cur.getValue()[1];
            if (row == m - 1 && col == n - 1) {
                return dist[row][col];
            }
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDist = Math.max(dist[row][col], Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if (newDist < dist[newRow][newCol]) {
                        pq.offer(new Pair(newDist, new int[]{newRow, newCol}));
                        dist[newRow][newCol] = newDist;
                    }
                }
            }
        }
        return -1;
    }
}

//tc: O((E + V) logv) = O(mn log(mn))
//sc: O(V) = O(mn)