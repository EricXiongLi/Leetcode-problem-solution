class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] : weather s.substring(i, end) can be word break;
        Boolean[] memo = new Boolean[s.length()];
        return dp(s, 0, new HashSet<String>(wordDict), memo);
    }
    
    private boolean dp(String s, int start, HashSet<String> wordDict, Boolean[] memo) {
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