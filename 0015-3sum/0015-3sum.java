class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++)  {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int curSum = nums[l] + nums[r];
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                
                if (nums[l] + nums[r] == target) {
                    List<Integer> level = new ArrayList<>();
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (curSum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}