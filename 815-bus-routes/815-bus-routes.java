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
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i : sourceSet) {
            if (targetSet.contains(i)) return 1;
            q1.offer(i);
            visited.add(i);
        }
        for (int j : targetSet) {
            q2.offer(j);
            visited.add(j);
        }
        int step = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            int sz = q1.size();
            for (int i = 0; i < sz; i++) {
                int cur = q1.poll();
                for (int nei : graph.getOrDefault(cur, new HashSet<Integer>())) {
                    if (q2.contains(nei)) return step + 1;
                    if (visited.contains(nei)) continue;
                    q1.offer(nei);
                    visited.add(nei);
                }
            }
            step++;
        }
        return -1;
    }
}