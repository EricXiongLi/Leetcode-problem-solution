class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length;
        int[] visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = 1;
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nei : graph[cur]) {
                    if (visited[nei] == visited[cur]) {
                        return false;
                    }
                    if (visited[nei] == 0) {
                        visited[nei] = -visited[cur];
                        q.offer(nei);
                    }
                }
            }
        }
        return true;
    }
}