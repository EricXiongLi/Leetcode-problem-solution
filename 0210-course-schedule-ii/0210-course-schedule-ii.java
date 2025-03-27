class Solution {
    public int[] findOrder(int numcourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] indegree = new int[numcourses];

        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            indegree[to]++;
            graph.computeIfAbsent(from, v -> new ArrayList<Integer>()).add(to);
            graph.computeIfAbsent(to, v -> new ArrayList<Integer>()).add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numcourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numcourses];

        int p = 0;
        int count = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                res[p++] = cur;
                count++;

                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }

        return count == numcourses ? res : new int[0];
    }
}