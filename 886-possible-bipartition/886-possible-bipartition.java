class Solution {
    boolean[] visited;
    int[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new int[n + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : dislikes) {
            int start = edge[0], end = edge[1];
            graph.computeIfAbsent(start, v -> new ArrayList<Integer>()).add(end);
            graph.computeIfAbsent(end, v -> new ArrayList<Integer>()).add(start);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if(!dfs(graph, i, 1)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, int preColor) {
        visited[cur] = true;
        color[cur] = preColor * -1;
        for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
            if (!visited[nei]) {
                if(!dfs(graph, nei, color[cur])) return false;
            } else {
                if (color[nei] == color[cur]) return false;
            }
        }
        return true;
    }
}