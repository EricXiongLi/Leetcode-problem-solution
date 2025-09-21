class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<Integer>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                //bfs
                count++;
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                   int cur = q.poll();

                   for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                        if (!visited[nei]) {
                            q.offer(nei);
                            visited[nei] = true;
                        }
                   }
                }
                
            }
        }

        return count;
    }
}