class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //y -x = k
            ///y = x + k
            //y - x = -k
            //y = -k + x
           map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) res++;
            } else {
                if (map.containsKey(key - k)) res++;
            }
        }

        return res;
    }
}