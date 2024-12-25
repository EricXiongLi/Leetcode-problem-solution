class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        long[] res = new long[n];
        //val, [sum of index, count];
        Map<Integer, long[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                long[] item = map.get(nums[i]);
                res[i] += ((i * item[1]) - item[0]);
            } else {
                map.put(nums[i], new long[2]);
            }
            long[] item = map.get(nums[i]);
            item[0] += i;
            item[1]++;
        }
        map.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                long[] item = map.get(nums[i]);
                res[i] += (item[0] - (long)(i * item[1]));
            } else {
                map.put(nums[i], new long[2]);
            }
            long[] item = map.get(nums[i]);
            item[0] += i;
            item[1]++;
        }

        return res;
    }
}