class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        //a, ab, abc, abcd, bacd
        //dp[s] = dp[s - 1] + 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int cur = 0;    
            for (int j = 0; j < word.length(); j++) {
                String prev = word.substring(0, j) + word.substring(j + 1, word.length());
                cur = Math.max(cur, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, cur);
            res = Math.max(cur, res);
        }
        
        return res;
    }
}