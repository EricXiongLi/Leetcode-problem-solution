class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) return 0;
        if (sum1 < sum2) {
            return minOperations(nums2, nums1);
        }
        int diff = sum1 - sum2;
        int[] op1 = new int[6];
        int[] op2 = new int[6];
        for (int num : nums1) {
            op1[num - 1]++;
        }
        for (int num : nums2) {
            op2[6 - num]++;
        }
        
        int p1 = 5;
        int p2 = 5;
        int count = 0;
        for (int i =5; i >= 1 && diff > 0; i--) {
            while (op1[i] > 0) {
                diff -= i;
                op1[i]--;
                count++;
                if (diff <= 0) return count;
            }
            while (op2[i] > 0) {
                diff -= i;
                op2[i]--;
                count++;
                if (diff <= 0) return count;
            }
        }
        return -1;
    }
} 