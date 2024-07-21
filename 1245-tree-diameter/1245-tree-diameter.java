class Solution {
    int res = 0;
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.putIfAbsent(u, new ArrayList<Integer>());
            graph.putIfAbsent(v, new ArrayList<Integer>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, graph);
        return res - 1;
    }
    
    //the longest subtree of node
    public int dfs(int node, int parent, Map<Integer, List<Integer>> graph) {
        if (graph.get(node) == null) {
            res = Math.max(1, res);
            return 0;
        }
        
        int maxDepth1 = 0, maxDepth2 = 0;
        
        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            int depth = dfs(nei,node, graph);
            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }
            res = Math.max(res, maxDepth1 + maxDepth2 + 1);
        }
        return maxDepth1 + 1;
    }
}

//tc: O(n)
//sc: O(n)