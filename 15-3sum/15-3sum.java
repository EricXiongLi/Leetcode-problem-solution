class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            if (nums[i] + nums[left] > 0) return res;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> level = new ArrayList<>();
                    level.add(nums[i]);
                    level.add(nums[left]);
                    level.add(nums[right]);
                    res.add(level);
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}