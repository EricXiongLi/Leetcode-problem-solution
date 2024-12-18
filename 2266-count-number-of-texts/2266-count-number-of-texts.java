class Solution {
    int MOD = 1000000007;
    
    public int countTexts(String keys) {
        List<int[]> list = new ArrayList<>();
        
        int l = 0;
        for (int r = 0; r < keys.length(); r++) {
            if (keys.charAt(r) != keys.charAt(l)) {
                list.add(new int[]{l,  r - 1});
                l = r;
            }
        }
        list.add(new int[]{l, keys.length() - 1});
        
        int res = 1;
        for (int[] range: list) {
            res = (int)((long)res * getCount(keys, range[0], range[1]) % MOD);
        }
        
        return res;
    }
    
    public int getCount(String s, int start, int end) {
        //7, 9
        //int len = end - start + 1;
        //dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        int len = end - start + 1;
        char c = s.charAt(start);
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (i - 1 >= 0) dp[i] = (dp[i] + dp[i - 1]) % MOD;
            if (i - 2 >= 0) dp[i] = (dp[i] + dp[i - 2]) % MOD;
            if (i - 3 >= 0) dp[i] = (dp[i] + dp[i - 3]) % MOD;
            if ((c == '7' || c == '9') && i - 4 >= 0) dp[i] = (dp[i] + dp[i - 4]) % MOD;
         }
        return dp[len] % MOD;
    }
}

//tc: O(n)
//sc: O(n)