class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
       //dp[i][0]: ending with A[i] = Math.max(dp[i - 1][0], dp[i - 2][1]) + A[i]
        //dp[i][1]: ending with B[i] = Math.max(dp[i - 1][1], dp[i - 2][0]) + B[i]
        
        int n = energyDrinkA.length;
        
        long[][] dp = new long[n + 2][2];
        
        for (int i = 2; i <= n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1]) + energyDrinkA[i - 2];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0]) + energyDrinkB[i - 2];
        }
        
        return Math.max(dp[n + 1][0], dp[n + 1][1]);
    }
}