class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dfs(4, ans, dq, nums, 0, nums.length - 1, (long)target);
        return ans;
    }
    
    private void dfs(int k, List<List<Integer>> ans, Deque<Integer> subAns,int[] nums, int start, int end, long target) {
        if (k == 2) {
            int l = start, r = end;
            while (l < r) {
                if ((long) nums[l] + (long) nums[r] == (long)target) {
                    subAns.offer(nums[l]);
                    subAns.offer(nums[r]);
                    ans.add(new ArrayList<>(subAns));
                    subAns.pollLast();
                    subAns.pollLast();
                    while (l + 1 < end && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    l++;
                    while (r - 1 > start && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    r--;    
                } else if ((long) nums[l] +  (long)  nums[r] < (long)target) {
                    l++;
                } else {
                    r--;
                }
                
                
            }
            return;
        } else {
            for (int i = start; i <= end - k + 1; i++) {
                subAns.offer(nums[i]);
                dfs(k - 1, ans, subAns, nums, i + 1, end, target - nums[i]);
                subAns.pollLast();
                while (i + 1 <= end - k + 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }
    }
}