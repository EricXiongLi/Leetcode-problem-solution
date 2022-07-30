class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] cur : prerequisites) {
            int end = cur[0], start = cur[1];
            graph.computeIfAbsent(start, v -> new LinkedList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nei : graph.getOrDefault(cur, new LinkedList<>())) {
                if (--indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}