class Solution {
    public int numDecodings(String s) {
        //dp[i]: the possible # of combination for string[i...n]
        //dp[i] = s[i] is 0 ? 0 :  s[i...i + 1] is a possible string, which is from 10 to 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1]

    //267
    //string[0...1]: 26 -> possible : dp[1] (67) + dp[2](7)

    int n = s.length();
    int[] dp = new int[n];

    //dp[6] = 1
    dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
    if (n == 1) return dp[0];
    dp[n - 2] = s.charAt(n - 2) == '0' ? 0 : (isPossible(s, n - 2) ? dp[n - 1] + 1 : dp[n - 1]);
    //dp[5] = 1
    for (int i = n - 3; i >= 0; i--) {
        dp[i] = s.charAt(i) == '0' ? 0 : ((isPossible(s, i) ? dp[i + 1] + dp[i + 2] : dp[i + 1]));
    }

    //dp[4] = 2

    //dp[3] = 3

    //dp[2] = 0

    //dp[1] = 0 + 3 = 3

    //dp[0] = 
    return dp[0];
    }

    public boolean isPossible(String s, int i) {
        int val = Integer.valueOf(s.substring(i, i + 2));

        return val >= 10 && val <= 26;
    }
}

