class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> cur = new HashMap<>();
        int l = 0;
        int n = nums.length;
        int res = 0;
        for (int r = 0; r < n; r++) {
            cur.put(nums[r], cur.getOrDefault(nums[r], 0) + 1);
            while (cur.size() == map.size()) {
                res += (n - r);
                cur.put(nums[l], cur.get(nums[l]) - 1);
                if (cur.get(nums[l]) == 0) {
                    cur.remove(nums[l]);
                }
                l++;
            }
        }
        return res;
    }
}