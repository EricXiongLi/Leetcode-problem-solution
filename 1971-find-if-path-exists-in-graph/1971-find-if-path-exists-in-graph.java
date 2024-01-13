class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (source == destination) {
            return true;
        }
        for (int[] edge : edges) {
            int start = edge[0], end=edge[1];
            map.computeIfAbsent(start, v -> new ArrayList<>()).add(end);
            map.computeIfAbsent(end, v -> new ArrayList<>()).add(start);
        }
        Set<Integer> set = new HashSet<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        set.add(source);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : map.get(cur)) {
                if (nei == destination) {
                    return true;
                }
                if (!set.contains(nei)) {
                    q.offer(nei);
                }
                set.add(nei);
            }
        }
        return false;
    }
}

//tc: O(n)
//sc: O(n)