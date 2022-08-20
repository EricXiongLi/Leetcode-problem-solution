class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));//end, cost
        Map<Integer, List<int[]>> graph = new HashMap<>();//end, cost
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(0, v -> new ArrayList<int[]>()).add(new int[]{i + 1, wells[i]});
            graph.computeIfAbsent(i + 1, v -> new ArrayList<int[]>()).add(new int[]{0, wells[i]});
        }
        for (int[] pipe : pipes) {
            int start = pipe[0], end = pipe[1], cost = pipe[2];
            graph.computeIfAbsent(start, v -> new ArrayList<int[]>()).add(new int[]{end, cost});
            graph.computeIfAbsent(end, v -> new ArrayList<int[]>()).add(new int[]{start, cost});
        }
        Set<Integer> visited = new HashSet<>();
        pq.offer(new int[]{0, 0});
        int totalCost = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curEnd = cur[0], curCost = cur[1];
            if (visited.contains(curEnd)) continue;
            visited.add(curEnd);
            totalCost += curCost;
            for (int[] nei : graph.getOrDefault(curEnd, new ArrayList<int[]>())) {
                int neiEnd = nei[0], neiCost = nei[1];
                if (visited.contains(neiEnd)) continue;
                pq.offer(new int[]{neiEnd, neiCost});
            }
        }
        return visited.size() == n + 1 ? totalCost : -1;
        
    }
}