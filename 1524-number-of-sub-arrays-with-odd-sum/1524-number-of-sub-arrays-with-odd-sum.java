class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>(); //<sum % 2, count>
        map.put(0, 1);
        int sum = 0;
        for (int num : arr) {
            sum = (sum + num) % 2;
            int target = sum ^ 1;
            if (map.containsKey(target)) {
                count = (count + map.get(target)) % MOD;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}