class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <prefix sum, frequency>
        int sum = 0, count = 0;
        map.put(0, 1);//点睛之笔
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }//先验证，再放，要不然k = 0时会把自己也算上了
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}