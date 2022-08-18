class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            int[] cur = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int start = flight[0], end = flight[1], cost = flight[2];
                if (dist[start] == Integer.MAX_VALUE) continue;
                cur[end] = Math.min(cur[end], dist[start] + cost);
            }
            dist = cur;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}