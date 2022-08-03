class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        dfs(res, tmp, n, k, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, Deque<Integer> tmp, int n, int k, int start) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp.offer(i);
            dfs(res, tmp, n, k, i + 1);
            tmp.pollLast();
        }
    }
}