class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), nums, 0);
        return res;
        
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        backtrack(res, tmp, nums, start + 1);
        tmp.add(nums[start]);
        backtrack(res, tmp, nums, start + 1);
        tmp.remove(tmp.size() - 1);
    }
}