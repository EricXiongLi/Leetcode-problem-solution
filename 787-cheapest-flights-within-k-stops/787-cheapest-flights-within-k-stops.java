class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();//[position, cost]
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);//[cost, position, stops left]
        for (int[] edge : flights) {
            graph.computeIfAbsent(edge[0], v-> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }
        pq.offer(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], curPos = cur[1], stops = cur[2];
            visited.put(curPos, stops);
            if (curPos == dst) return cost;
            if (stops > 0) {
                for (int[] nei : graph.getOrDefault(curPos, new ArrayList<int[]>())) {
                    int neiPos = nei[0], neiCost = nei[1];
                    if (!visited.containsKey(neiPos) || stops > visited.get(neiPos)) {
                        pq.offer(new int[]{cost + neiCost, neiPos, stops - 1});
                    }
                }
            }
        }
        return -1;
    }
}