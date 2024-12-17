class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        //dp[i]: the maximum value ending with s[i]
        //dp[i] = Math.max(0, dp[i - 1] + value[i]);
        int res = 0;
        Map<Character, Integer> values = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            values.put(c, vals[i]);
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int curVal = (values.containsKey(c) ? values.get(c) : c - 'a' + 1);
            dp[i] = Math.max(curVal, dp[i - 1] + curVal);
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}