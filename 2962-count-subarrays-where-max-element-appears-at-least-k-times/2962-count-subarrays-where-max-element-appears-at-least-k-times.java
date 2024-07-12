class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int maxNum = Arrays.stream(nums).max().getAsInt();
        //num -> frequency
        Map<Integer, Integer> map = new HashMap();
        int start = 0;
        long res = 0;
        for (int end = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if (nums[end] == maxNum && map.get(maxNum) >= k) {
                // the num of appropriate array with start as its left border
                res += (n - end);
            }
            
            while (map.getOrDefault(maxNum, 0) >= k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(maxNum) >= k) {
                    res += (n - end);
                }
                start++;
            }
        }
        
        return res;
    }
}