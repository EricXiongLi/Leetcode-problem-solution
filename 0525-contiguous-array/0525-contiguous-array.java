class Solution {
    public int findMaxLength(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) count0++;
            else {
                count1++;
            }
            map.put(count0 - count1, i);
        }
        int res = 0;
        if (map.containsKey(0)) {
            res = map.get(0) + 1;
        }
        count0 = 0;
        count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else {
                count1++;
            }
            int diff = count0 - count1;
            if (map.containsKey(diff)) {
                res = Math.max(map.get(diff) - i, res);
            }
        }
        return res;
    }
}