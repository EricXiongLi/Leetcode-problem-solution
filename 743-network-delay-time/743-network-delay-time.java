class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //[distance, node]
        pq.offer(new int[]{0, k});
        int res = 0;
        Map<Integer, Integer> distance = new HashMap<>(); //node, distance
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist1 = cur[0], node1 = cur[1];
            if (distance.containsKey(node1)) continue;
            distance.put(node1, dist1);
            res = Math.max(res, dist1);
            for (int[] edge : graph.getOrDefault(node1, new ArrayList<int[]>())) {
                int dist2 = edge[1], node2 = edge[0];
                if (!distance.containsKey(node2)) {
                    pq.offer(new int[]{dist2 + dist1, node2});
                }
            }
        }
        if (distance.size() != n) return -1;
        return res;
    }
}