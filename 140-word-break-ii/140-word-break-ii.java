class Solution {
    Boolean[] memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Deque<String> level = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        dfs(s, 0, new HashSet<String>(wordDict), res, level);
        return res;
    }
    
    private void dfs(String s, int start, Set<String> wordDict, List<String> res, Deque<String> level) {
        if (start == s.length()) {
            res.add(String.join(" ", level));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (wordDict.contains(sub)) {
                level.offer(sub);
                dfs(s, i, wordDict, res, level);
                level.pollLast();
            }
        }
    }
}