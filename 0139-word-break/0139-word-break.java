class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]: whethere s[0: i] can be segmented

        //recurence relation
        //dp[i] = Any(dp[i - word.length()] && s[i - word.length() + 1, i] is in wordDict)
        int n = s.length();

        Boolean[] memo = new Boolean[n];
        Set<String> dict = new HashSet<>(wordDict);
        return dp(n - 1, memo, dict, s);
    }

    public boolean dp(int i, Boolean[] memo, Set<String> dict, String s) {
        if (i < 0) return true;
        if (memo[i] != null) return memo[i];

        for (String word : dict) {
            if (i - word.length() + 1 >= 0 && dict.contains(s.substring(i - word.length() + 1, i + 1)) && dp(i - word.length(), memo, dict, s)) {
                memo[i] = true;
                return memo[i];
            }
        }
        memo[i] = false;

        return false;
    }
}