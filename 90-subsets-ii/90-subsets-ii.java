class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[start]);
        backtrack(res, tmp, nums, start + 1);
        tmp.remove(tmp.size() - 1);
        while (start + 1 <= nums.length - 1 && nums[start + 1] == nums[start]) {
            start++;
        }
        backtrack(res, tmp, nums, start + 1);
    }
}