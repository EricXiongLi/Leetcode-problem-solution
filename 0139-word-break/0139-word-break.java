class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]: whether the s[i: end] can be 
        int n = s.length();
        Boolean[] memo = new Boolean[n];
        return dp(s, 0, new HashSet<>(wordDict), memo);
    }
    
    public boolean dp(String s, int start, Set<String> wordDict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        memo[start] = false;
        for (int i = s.length(); i >= start; i--) {
            String sub = s.substring(start, i);
            if (wordDict.contains(sub)) {
                if (dp(s, i, wordDict, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
            
        }
        return memo[start];
    }
}