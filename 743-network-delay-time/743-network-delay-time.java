class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], v -> new ArrayList<int[]>()).add(new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(k, 0);
        while (true) {
            int curNode = -1, minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && dist.get(i) < minDist) {
                    curNode = i;
                    minDist = dist.get(i);
                }
            }
            if (curNode == -1) break;
            visited[curNode] = true;
            for (int[] nei : graph.getOrDefault(curNode, new ArrayList<int[]>())) {
                dist.put(nei[0], Math.min(dist.get(nei[0]), dist.get(curNode) + nei[1]));
            }
        }
        int max = 0;
        for (int distance : dist.values()) {
            max = Math.max(max, distance);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
                                             
                                             
}