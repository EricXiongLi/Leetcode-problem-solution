class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new LinkedList<Integer>());
        return res;
    }
    
    public void dfs(int[] nums, int cur, List<Integer> tmp) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        dfs(nums, cur + 1, tmp);
        tmp.add(nums[cur]);
        dfs(nums, cur + 1, tmp);
        tmp.remove(tmp.size() - 1);
    }
}