class Solution {
    public int numDecodings(String s) {
        //dp[i]: the # of combination for s[i...n]

        //dp[i] = s[i] == '0' ? 0
        //for (i), (others) ways, dp[i] += (s[i] == '*' ? 9 : 1) * dp[i + 1]
        //for (i, i + 1), (others) ways, dp[i] += (numDecodings(s[i...i+1) * dp[i + 2]);
        int n = s.length();
        int MOD = (int)1e9 + 7;
        int[] dp = new int[n];
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : (s.charAt(n - 1) == '*' ? 9 : 1);
        //dp[1] = 9
        if (n == 1) return dp[0];
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = (int)(((long)(s.charAt(i) == '*' ? 9 : 1) * dp[i + 1]) % MOD);
                //dp[0] = 81
                dp[i] = (int)((dp[i] + (long)getWays(s, i) * (i == n - 2 ? 1 : dp[i + 2])) % MOD);
                //dp[0] += 16
            }
        }

        return dp[0];
    }

    public int getWays(String s, int i) {
        //10, 11, 12, 13, 14, ..., 26: 1
        //*0, *1, *2, *3, *4, *5, *6: 2
        //*7, *8, *9: 1
        //1*: 9
        //2*: 21-26: 6
        //3*, 4*, 5*, ..., 9*: 0
        //**: 11-19, 21-26: 15

        if (s.charAt(i) == '*') {
            char c = s.charAt(i + 1);
            if (c >= '0' && c <= '6') {
                return 2;
            } else if (c >= '7' && c <= '9') {
                return 1;
            } else {
                return 15;
            }
        } else if (s.charAt(i + 1) == '*') {
            char l = s.charAt(i);

            if (l == '1') {return 9;}
            else if (l == '2') {
                return 6;
            } else if (l >= '3' && l <= '9') {
                return 0;
            }
        } else if (Integer.valueOf(s.substring(i, i + 2)) >= 10 && Integer.valueOf(s.substring(i, i+ 2)) <= 26) {
            return 1;
        }
        return 0;
    }
}