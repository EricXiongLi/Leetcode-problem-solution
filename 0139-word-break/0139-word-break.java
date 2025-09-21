class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]: whether s[0: i] can be segmented

        //recurrence relation
        //dp[i] = any(dp[i - word.length()] && wordDict.contains(s[i - word.length() + 1: i]))
        int n = s.length();
        boolean[] dp = new boolean[n];
        Set<String> dict = new HashSet<>(wordDict);

        //O(n)
        for (int i = 0; i < n; i++) {
            // O(m)
            for (String word : wordDict) {
                //O(K)
                if (i - word.length() + 1 >= 0 && dict.contains(s.substring(i - word.length() + 1, i + 1)) && (i - word.length() < 0 || dp[i - word.length()])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}

//tc: O(nmk)

// /sc: O(n)