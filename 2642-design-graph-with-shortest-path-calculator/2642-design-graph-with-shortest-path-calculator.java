class Graph {
    Map<Integer, List<int[]>> graph;
    int N;
    public Graph(int n, int[][] edges) {
        N = n;
        graph = new HashMap();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        graph.computeIfAbsent(edge[0], v -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }
    
    public int dijkstra(int start, int end) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        //[distance, node] (from start node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, start});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1], curDist = cur[0];
            if (cur[1] == end) {
                return distance[end];
            }
            
            for (int[] nei : graph.getOrDefault(cur[1], new ArrayList<int[]>())) {
                int neiNode = nei[0];
                if (curDist + nei[1] < distance[neiNode]) {
                    distance[neiNode] = curDist + nei[1];
                    pq.offer(new int[]{distance[neiNode], neiNode});
                }
            }
        }
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */