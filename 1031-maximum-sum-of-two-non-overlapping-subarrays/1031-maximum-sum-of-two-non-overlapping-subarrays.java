class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int l1, int l2) {
        int n = nums.length;
        
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i]; 
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        Arrays.fill(leftMax, -1);
        leftMax[l1 - 1] = prefixSum[l1 - 1];
        
        for (int i = l1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], prefixSum[i] - prefixSum[i - l1]);
        }
        
        Arrays.fill(rightMax, -1);
        rightMax[n - l1] = prefixSum[n - 1] - prefixSum[n - l1 - 1];
        
        for (int i = n - l1 - 1; i >= 0; i--) {
            if (i + l1 - 1 >= n) {
                rightMax[i] = -1;
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], prefixSum[i + l1 - 1] - (i - 1 >= 0 ? prefixSum[i - 1] : 0));

            }
        }
        int res = Integer.MIN_VALUE;
        for (int  i = 0; i <= n - l2; i++) {
            int cur = prefixSum[i + l2 - 1] - (i - 1 >= 0 ? prefixSum[i - 1] : 0);
            int side = 0;
            if (i - 1 >= 0 && leftMax[i - 1] != -1) side = leftMax[i - 1];
            if (i + l2 < n && rightMax[i + l2] != - 1) side = Math.max(side, rightMax[i + l2]);
            res = Math.max(cur + side, res);
        }
        
        return res;
        
    }
}

//tc: O(n)
//sc: O(n)