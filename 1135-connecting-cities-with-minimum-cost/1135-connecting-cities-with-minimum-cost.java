class Solution {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge: connections) {
            int start = edge[0], end = edge[1], cost = edge[2];
            graph.computeIfAbsent(start, v -> new ArrayList<int[]>()).add(new int[]{end, cost});
            graph.computeIfAbsent(end, v -> new ArrayList<int[]>()).add(new int[]{start, cost});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{1, 1, 0});
        Set<Integer> visited = new HashSet<>();
        int costs = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curStart = cur[0], curEnd = cur[1], curCost = cur[2];
            if (visited.contains(curEnd)) continue;
            costs += curCost;
            visited.add(curEnd);
            for (int[] nei : graph.getOrDefault(curEnd, new ArrayList<int[]>())) {
                int neiEnd = nei[0], neiCost = nei[1];
                    pq.offer(new int[]{curEnd, neiEnd, neiCost});
                
            }
        }
        return visited.size() == n ? costs : -1;
    }
}