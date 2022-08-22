class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();//stopNum, busNum;
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                map.computeIfAbsent(j, v -> new HashSet<Integer>()).add(i);
            }
        }
        Set<Integer> sourceSet = map.get(source);
        Set<Integer> targetSet = map.get(target);
        if (targetSet == null) return -1;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                for (int k : map.get(j)) {
                    if (k != i) {
                        graph.computeIfAbsent(i, v -> new HashSet<Integer>()).add(k);
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i : sourceSet) {
            q.offer(i);
            visited.add(i);
        }
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (targetSet.contains(cur)) return step;
                for (int nei : graph.getOrDefault(cur, new HashSet<Integer>())) {
                    if (visited.contains(nei)) continue;
                    q.offer(nei);
                    visited.add(nei);
                }
            }
            step++;
        }
        return -1;
    }
}