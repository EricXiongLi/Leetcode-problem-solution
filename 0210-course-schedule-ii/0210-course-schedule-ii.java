class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int n = numCourses;
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < pre.length; i++) {
            int start = pre[i][1], end = pre[i][0];
            indegree[end]++;
            map.computeIfAbsent(start, v-> new ArrayList<>()).add(end);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for (int nei : map.getOrDefault(cur, new ArrayList<>())) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        if (res.size() != n) {
            return new int[0];
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}