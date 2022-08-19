class Solution {
    boolean[] visited;
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!bfs(graph, i)) return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int[][] graph, int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        color[root] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            
            for (int nei : graph[cur]) {
                if (!visited[nei]) {
                    color[nei] = -1 * color[cur];
                    q.offer(nei);
                } else {
                    if (color[nei] == color[cur]) return false;
                }
            }
        }
        return true;
    }
}