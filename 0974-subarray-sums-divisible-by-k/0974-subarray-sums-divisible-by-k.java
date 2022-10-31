class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i] % k + k ) % k;
            if (map.containsKey(sum)) {
                res += map.get(sum);
            }
            // System.out.println(-6 % 5);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}