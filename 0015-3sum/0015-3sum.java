class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //[-4, -1, -1, 0, 1, 2]
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            while (l < r) {
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (r != n - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                if (nums[l] + nums[r] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}