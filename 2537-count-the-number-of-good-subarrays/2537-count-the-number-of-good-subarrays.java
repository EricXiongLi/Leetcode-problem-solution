class Solution {
    public long countGood(int[] nums, int k) {
        int count = 0;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            count += (map.get(nums[r]) - 1);
            
            while (count >= k) {
                if (count >= k) {
                    res += (n - r);
                }
                map.put(nums[left], map.get(nums[left]) - 1);
                count -= map.get(nums[left]);
                left++;
            }
        }
        
        return res;
    }
}