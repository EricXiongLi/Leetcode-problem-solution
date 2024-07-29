class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int[] relation : relations) {
            int start = relation[0], end = relation[1];
            graph.computeIfAbsent(start - 1, v -> new ArrayList<Integer>()).add(end - 1);
            indegree[end - 1]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        if (q.isEmpty()) {
            return -1;
        }
        
        int level = 0;
        List<Integer> res = new ArrayList();
        while (!q.isEmpty()) {
            int sz = q.size();
            level++;
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                res.add(cur);
                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        
        return res.size() == n ? level : -1;
    }
}