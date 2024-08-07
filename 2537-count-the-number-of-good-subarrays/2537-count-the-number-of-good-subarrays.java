class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        int start = 0;
        long res = 0;
        int n = nums.length;
        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            count += map.get(nums[end]) - 1;
            while (count >= k) {
                res += n - 1 - end + 1;
                count -= (map.get(nums[start]) - 1);
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
        }
        
        return res;
    }
}