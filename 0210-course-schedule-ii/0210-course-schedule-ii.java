class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int start = pre[1], end = pre[0];
            indegree[end]++;
            graph.computeIfAbsent(start, v -> new ArrayList<>()).add(end);
        }
        List<Integer> res = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}