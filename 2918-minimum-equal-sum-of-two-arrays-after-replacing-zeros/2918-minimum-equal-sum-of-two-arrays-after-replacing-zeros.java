class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        //sumA range: [sumA, +infinity) or [sumA, sumA]
        long sumA = 0, sumB = 0;
        int countA = 0, countB = 0;
        for (int num : nums1) {
            sumA += Math.max(1, num);
            if (num == 0) {
                countA++;
            }
        }
        
        for (int  num : nums2) {
            sumB += Math.max(1, num);
            if (num == 0) {
                countB++;
            }
        }
        
        if (countA == 0 && sumB > sumA) {
            return -1;
        }
        
        if (countB == 0 && sumA > sumB) {
            return -1;
        }
        
        return Math.max(sumA, sumB);
    }
}