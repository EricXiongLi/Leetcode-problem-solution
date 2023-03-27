class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            int end = pre[0], start = pre[1];
            map.computeIfAbsent(start, v -> new ArrayList<Integer>()).add(end);
            indegree[end]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
            }
        }
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            count++;
            for (int nei : map.getOrDefault(cur, new ArrayList<Integer>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    dq.offer(nei);
                }
            }
        }
        return count == numCourses;
        
        
    }
}