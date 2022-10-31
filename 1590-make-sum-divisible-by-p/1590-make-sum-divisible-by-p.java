class Solution {
    public int minSubarray(int[] nums, int p) {
        //sum - x = np
        //x = sum - np
        //sum - x == np
        //sum - (x1 - x2) == np
        //sum - x1 + x2 == np
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int prefix = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % p == 0) return 0;
        int res = Integer.MAX_VALUE;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int) ((p - (sum - prefix) % p) % p);
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            map.put(prefix, i);
        }
        return res == nums.length ? -1 : res;
    }
}