class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            int start = edge[1], end = edge[0];
            indegree[end]++;
            graph.computeIfAbsent(start,  v-> new ArrayList<Integer>()).add(end);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[count] = cur;
            count++;
            for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
}