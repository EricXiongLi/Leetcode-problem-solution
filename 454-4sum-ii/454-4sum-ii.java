class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>();//<sum, freq>
        Map<Integer, Integer> map2 = new HashMap<>();//<sum, freq>
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int curSum = nums1[i] + nums2[j];
                map1.put(curSum, map1.getOrDefault(curSum, 0) + 1);
            }
        }
        int res = 0;
        for (int k = 0; k < nums3.length; k++) {
            for (int p = 0; p < nums4.length; p++) {
                int curSum = nums3[k] + nums4[p];
                res += map1.getOrDefault(-curSum, 0);
            }
        }
        return res;
    }
}