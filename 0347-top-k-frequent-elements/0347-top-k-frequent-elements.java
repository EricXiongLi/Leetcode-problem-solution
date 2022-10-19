class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[n + 1];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new ArrayList<Integer>();
            }
            bucket[e.getValue()].add(e.getKey());
        }
        List<Integer> res = new ArrayList<>();
        System.out.println("map is" + map);
        System.out.println("list is" + Arrays.toString(bucket));
        for (int i = n; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                res.add(val);
                if (res.size() == k) {
                    return res.stream().mapToInt(j -> j).toArray();
                }
            }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}