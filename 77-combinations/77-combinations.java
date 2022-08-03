class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        dfs(res, tmp, n, k, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, Deque<Integer> tmp, int n, int k, int start) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
       
            if (start <= n - (k - tmp.size())) {
                dfs(res, tmp, n, k, start+ 1);
                tmp.offer(start);
                dfs(res, tmp, n, k, start + 1);
                tmp.pollLast();
            } else {
                tmp.offer(start);
                dfs(res, tmp, n, k, start + 1);
                tmp.pollLast();
            }
    }
}