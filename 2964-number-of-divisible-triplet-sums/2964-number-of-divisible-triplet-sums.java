class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int remainder = (nums[j] + nums[i - 1]) % d;
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
            int target = (d - nums[i] %d) % d;
            res += map.getOrDefault(target, 0);
        }

        return res;
    }
}