class Solution {
    boolean[] visited;
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, 1)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int cur, int preColor) {
        visited[cur] = true;
        color[cur] = preColor * -1;
        for (int nei : graph[cur]) {
            if (!visited[nei]) {
                if (!dfs(graph, nei, color[cur])) return false;
            } else {
                if (color[nei] == color[cur]) return false;
                
            }
        }
        return true;
        
    }
}