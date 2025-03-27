class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0, new LinkedList<Integer>());
        return res;
    }

    public void backtracking(int[] candidates, int target, int i, int curSum, Deque<Integer> curList)  {
        if (curSum == target) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            curSum += candidates[j];
            curList.push(candidates[j]);
            if (curSum <= target) {
                backtracking(candidates, target, j, curSum, curList);
            }
            curSum -= candidates[j];
            curList.pop();

            //
        }
    }
}