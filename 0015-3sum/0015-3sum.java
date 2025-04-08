class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 2; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                
                if (map.getOrDefault(nums[j], 0) < 3) {
                    int target = -nums[i] - nums[j];
                        if (map.containsKey(target)) {
                            List<Integer> cur = Arrays.asList(nums[j], nums[i], target);
                            Collections.sort(cur);
                            res.add(cur);
                        }
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
            }
        }

        return new ArrayList(res);
    }
}