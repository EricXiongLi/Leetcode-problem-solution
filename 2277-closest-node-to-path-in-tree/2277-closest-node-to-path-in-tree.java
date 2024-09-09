class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[][] dist = new int[1001][1001];
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<Integer>()).add(edge[0]);
        }
        for (int node : graph.keySet()) {
            bfs(node);
        }
        List<Integer> res = new ArrayList<>();
        for (int[] q : query) {
                
                Queue<Integer> queue = new ArrayDeque<>();
                int start = q[0], end = q[1], node = q[2];
            int ans = dist[start][node];
                queue.offer(start);
            int ansNode = start;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    if (cur == node) {
                        ansNode = node;
                        break;
                    }
                    for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                        
                        if (dist[cur][end] == dist[nei][end] + 1) {
                            if (dist[nei][node] < ans) {
                                ansNode = nei;
                            }
                            ans = Math.min(ans, dist[nei][node]);
                            queue.offer(nei);
                        }
                    }
                }
                res.add(ansNode);
            }
            
            
        
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    //calculate the dist for each node
    public void bfs(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                dist[node][cur] = step;
                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    if (!visited.contains(nei)) {
                        q.offer(nei);
                        visited.add(nei);
                    }
                } 
            }
            step++;
        }
    }
}