class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            graph.putIfAbsent(start, new ArrayList<Integer>());
            graph.get(start).add(end);
            graph.putIfAbsent(end, new ArrayList<Integer>());
            graph.get(end).add(start);
        }
        //0: not visited yet, 1: visited
        int visited[] = new int[n];
        int count = 0;
        Queue<Integer> q = new ArrayDeque();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                count++;
                q.offer(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                        if (visited[nei] == 0) {
                            visited[nei] = 1;
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}

//tc: O(n)
//sc: O(n)