class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int key : freq.keySet()) {
            int val = freq.get(key);
            map.computeIfAbsent(val, v -> new LinkedList<Integer>()).add(key);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 1; i--) {
            for (int val : map.getOrDefault(i, new LinkedList<Integer>())) {
                if (j < k) {
                    res[j] = val;
                    j++;
                }
            }
        }

        return res;
    }
}