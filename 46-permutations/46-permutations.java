class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, Deque<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tmp.offer(nums[i]);
                dfs(res, tmp, nums, used);
                tmp.pollLast();
                used[i] = false;
            }
        }
    }
}