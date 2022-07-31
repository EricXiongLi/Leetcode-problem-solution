class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int end = pre[0], start = pre[1];
            indegree[end]++;
            graph.computeIfAbsent(start, v -> new ArrayList<>()).add(end);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            count++;
            for (int i : graph.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return count == numCourses ? ans : new int[0];
    }
}