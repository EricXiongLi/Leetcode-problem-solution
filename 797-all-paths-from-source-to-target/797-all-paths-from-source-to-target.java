class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        path.offer(0);
        dfs(res, path, 0, graph);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, Deque<Integer> path, int start, int[][] graph) {
        if (start == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        } 
        for (int nei : graph[start]) {
            path.offer(nei);
            dfs(res, path, nei, graph);
            path.pollLast();
        }
    }
}