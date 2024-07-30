class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap();
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> ancestors = new HashMap();
        
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new ArrayDeque();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                ancestors.computeIfAbsent(nei, v -> new HashSet<Integer>()).add(cur);
                ancestors.get(nei).addAll(ancestors.getOrDefault(cur, new HashSet<Integer>()));
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                if (i != j && ancestors.getOrDefault(i, new HashSet<Integer>()).contains(j)) {
                    res.get(i).add(j);
                }
            }
        }
        
        return res;
    }
}