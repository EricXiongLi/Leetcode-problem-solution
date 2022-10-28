class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, (long)target, 4, 0, nums.length - 1);
        return res;
    }
    
    void dfs(int[] nums, long target, int k, int l, int r) {
        if (k == 2) {
            int left = l, right = r;
            while (left < right) {
                if (left != l && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }
                if (right != r && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if ((long)(nums[left] + nums[right]) == target) {
                    cur.offer(nums[left]);
                    cur.offer(nums[right]);
                    res.add(new ArrayList<>(cur));
                    cur.pollLast();
                    cur.pollLast();
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = l; i <= r - (k - 1); i++) {
                if (i != l && nums[i - 1] == nums[i]) {
                    continue;
                }
                cur.offer(nums[i]);
                dfs(nums, target - nums[i], k - 1, i + 1, r);
                cur.pollLast();
            }
        }
    }
    
    
}