class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] visited = new int[m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (visited[i] != 0) {
                continue;
            }
            q.offer(i);
            visited[i] = 1;
            while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (visited[nei] == 0) {
                    visited[nei] = -visited[cur];
                    q.offer(nei);
                }
                else if (visited[nei] == visited[cur]) {
                    return false;
                }
            }
        }
        }
        
        return true;
    }
}