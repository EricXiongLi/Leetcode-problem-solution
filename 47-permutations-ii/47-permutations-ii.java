class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new ArrayDeque<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, Deque<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            tmp.offer(nums[i]);
            used[i] = true;
            dfs(res, tmp, nums, used);
            tmp.pollLast();
            used[i] = false;
        }
    }
}