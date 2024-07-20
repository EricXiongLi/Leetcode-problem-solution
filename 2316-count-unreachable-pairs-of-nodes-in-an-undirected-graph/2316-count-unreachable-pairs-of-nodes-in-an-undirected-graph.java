class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap();
        List<Long> group = new ArrayList();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new ArrayList());
            graph.putIfAbsent(end, new ArrayList());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        Set<Integer> visited = new HashSet();
        
        for (int i = 0; i< n; i++) {
            if (!visited.contains(i)) {
                group.add(countSize(i, visited, graph));
            }
        }
        int l = group.size();
        long res = 0L;
        
        long sum = group.stream().mapToLong(Long::longValue).sum();
        for (long num : group) {
            res += (num * (sum - num));
        }
        
        return res / 2;
    }
    
    public long countSize(int i, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        Deque<Integer> q = new ArrayDeque();
        q.offer(i);
        visited.add(i);
        long size = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            size++;
            for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                if (!visited.contains(nei)) {
                    q.offer(nei);
                    visited.add(nei);
                }
            }
        }
        return size;
    }
}

//tc: O(n)
//sc: O(n)