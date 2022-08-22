class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] indegree = new int[m * n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curRow = i;
                int curCol = j;
                int curPos = i * n + j;
                for (int[] dir : dirs) {
                    int newRow = curRow + dir[0];
                    int newCol = curCol + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[curRow][curCol]) {
                        int newPos = newRow * n + newCol;
                        graph.computeIfAbsent(curPos, v -> new ArrayList<Integer>()).add(newPos);
                        indegree[newPos]++;
                    }
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m * n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
            level++;
        }
        return level;
    }
}