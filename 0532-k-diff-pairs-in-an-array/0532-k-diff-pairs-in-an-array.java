class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);            
        }
        int res = 0;
        for (int val : map.keySet()) {
            if ((k > 0 && map.containsKey(val + k)) || (k == 0 && map.get(val) > 1)) {
                res++;
            }
        }
        return res;
    }
}