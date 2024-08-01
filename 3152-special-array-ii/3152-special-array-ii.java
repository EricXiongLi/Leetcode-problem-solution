class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] nums2 = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                nums2[i] = 1;
            }
            prefixSum[i] = prefixSum[i - 1] + nums2[i];
        }

        for (int i = 0; i < n; i++) {
            
            System.out.println(prefixSum[i]);
        }

        int l = queries.length;
        boolean[] res = new boolean[l];

        for (int i = 0; i < l; i++) {
            int[] q = queries[i];
            int result = prefixSum[q[1]] - prefixSum[q[0]];
            res[i] = (result == 0 ? true : false);
        }

        return res;
    }
}