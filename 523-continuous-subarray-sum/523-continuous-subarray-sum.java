class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); //<remainder, index of the remainder>
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >=2 ) return true;
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}