class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
     }
    
    public int atMost(int[] nums, int k) {
        int res = 0, left = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <int, times it appears>
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);
            while (map.size() > k) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}