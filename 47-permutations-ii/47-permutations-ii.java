class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> level = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, level, nums, used);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, Deque<Integer> level, int[] nums, boolean[] used) {
        if (level.size() == nums.length) {
            res.add(new ArrayList<>(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //case1: used[i]
            //case2: i - 1 >= 0 && nums[i] = nums[i - 1] && !used[i - 1]
            if (used[i] || (i > 0 && nums[i] == nums[i -1] && !used[i - 1])) continue;
            level.offer(nums[i]);
            used[i] = true;
            dfs(res, level, nums, used);
            used[i] = false;
            level.pollLast();
        }
    }
}