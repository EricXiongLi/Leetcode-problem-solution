class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!dfs(graph, i, visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph, int cur, int[] visited) {
        for (int nei : graph[cur]) {
            if (visited[nei] == visited[cur]) {
                return false;
            }
            if (visited[nei] == 0) {
                visited[nei] = -1 * visited[cur];
                if (!dfs(graph, nei, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}