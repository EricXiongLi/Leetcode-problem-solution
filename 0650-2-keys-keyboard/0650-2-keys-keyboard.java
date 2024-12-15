class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i / 2; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j - 1) + 1;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}

//tc: O(n ^ 2)
//sc: O(n)