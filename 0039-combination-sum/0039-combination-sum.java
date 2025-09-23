class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new LinkedList<>();
        int n = candidates.length;
        backtracking(0, n - 1, path, res, candidates, target);
        return res;
    }

    public void backtracking(int start, int n, Deque<Integer> path, List<List<Integer>> res, int[] candidates, int target) {
        //option: discard candidate[i] or not
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (start > n || target < 0 || target == 1) {
            return;
        }
        backtracking(start + 1, n, path, res, candidates, target);
        
        path.push(candidates[start]);
        backtracking(start, n, path, res, candidates, target - candidates[start]);
        path.pop();

        
        

        
    }
}