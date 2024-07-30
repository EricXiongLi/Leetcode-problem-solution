class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap();
        Map<Integer, Set<Integer>> ancestors = new HashMap();
        int[] indegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], v -> new ArrayList<Integer>()).add(pre[1]);
            indegree[pre[1]]++;
        }
        
        Queue<Integer> q = new ArrayDeque();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                ancestors.computeIfAbsent(nei, v -> new HashSet<Integer>()).add(cur);
                ancestors.get(nei).addAll(ancestors.getOrDefault(cur, new HashSet<Integer>()));
                if (--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        List<Boolean> res = new ArrayList();
        for (int[] query : queries) {
            if (ancestors.getOrDefault(query[1], new HashSet<Integer>()).contains(query[0])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        
        return res;
    }
}