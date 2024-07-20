class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap();
        int n = bombs.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                graph.putIfAbsent(i, new ArrayList<Integer>());
                long curRow = bombs[i][0], curCol = bombs[i][1], neiRow = bombs[j][0], neiCol = bombs[j][1], range = bombs[i][2];
                if ((curRow - neiRow) * (curRow - neiRow) + (curCol - neiCol) * (curCol - neiCol) <= range * range) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet();
            
            Queue<Integer> q = new LinkedList();
            q.offer(i);
            visited.add(i);
            int num = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                num++;
                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    if (!visited.contains(nei)) {
                        q.offer(nei);
                        visited.add(nei);
                    }
                }
            }
            res = Math.max(res, num);
        }
        
        return res;
    }
}

//tc: O(n ^ 3)
//sc: O(n ^ 2)