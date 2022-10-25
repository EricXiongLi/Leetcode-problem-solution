class Solution {
    public int countHousePlacements(int n) {
        //dp[i]: ways starting from i
        //dp[i] = dp[i + 2] + dp[i + 1];
        int MOD = (int)1e9 + 7;
    
        int next1 = 1;
        int next2 = 1;
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = next1 % MOD + next2 % MOD;
            next2 = next1;
            next1 = cur;
        }
        return (int) ((1L * cur * cur) % MOD);
    }
}

