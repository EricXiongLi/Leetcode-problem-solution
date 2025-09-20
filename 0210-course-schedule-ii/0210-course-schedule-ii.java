class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            graph.computeIfAbsent(from, v -> new LinkedList<Integer>()).add(to);
            indegree[to]++;
        } 

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new LinkedList<>();

        while (!q.isEmpty()) {
            int cur =q.poll();

            res.add(cur);

            for (int nei : graph.getOrDefault(cur, new LinkedList<Integer>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        if (res.size() != numCourses) return new int[0];
        return res.stream().mapToInt(i -> i).toArray();
    }
}