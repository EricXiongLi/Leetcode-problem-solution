class Solution {
    public int numSubmatrixSumTarget(int[][] nums, int target) {
        int m = nums.length, n = nums[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i][j - 1] + nums[i][j];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += nums[k][j] - (i == 0 ? 0 : nums[k][i - 1]);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}