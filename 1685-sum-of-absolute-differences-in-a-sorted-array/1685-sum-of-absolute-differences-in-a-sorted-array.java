class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int curSum = 0;
        int[] res = new int[n];
        //l: k - k1 + k - k2 + k - k3 + k - k4... 
        //r: kn - k + k(n-1) - k + 
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            curSum += nums[i];
            int r = sum - curSum - num * (n - i - 1);
            int l = num * (i + 1) - curSum;
            res[i] = l + r;
        }
        
        return res;
    }
}