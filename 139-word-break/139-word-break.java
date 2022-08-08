class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        memo = new Boolean[len + 1];
        return dfs(s, len, new HashSet<>(wordDict));
    }

    private boolean dfs(String s, int n, Set<String> dict) {
        if (n == 0) {
            return true;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = false;
        for (int i = 0; i < n; i++) {
            boolean right = dict.contains(s.substring(i, n));
            if (!right) {
                continue;
            }
            boolean left = dfs(s, i, dict);
            if (left) {
                memo[n] = true;
                break;
            }
        }
        return memo[n];
    }
}