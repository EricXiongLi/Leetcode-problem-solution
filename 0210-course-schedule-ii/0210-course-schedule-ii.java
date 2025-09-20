class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        List<Integer> res = new LinkedList<>();

        for (int[] pre : prerequisites) {
            int src = pre[1], dest = pre[0];
            graph.computeIfAbsent(src, v -> new LinkedList<Integer>()).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res.add(cur);

                for (int nei : graph.getOrDefault(cur, new LinkedList<Integer>())) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }

        if (res.size() != numCourses) return new int[0];
        return res.stream().mapToInt(i -> i).toArray();

    }
}

//tc: O(V + E)

//sc: O(V + E)