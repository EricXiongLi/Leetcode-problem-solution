class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        int step = 1;
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> swap = q1;
                q1 = q2;
                q2 = swap;
            }
            Set<String> newSet = new HashSet<>();
            for (String s : q1) {
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < sb.length(); i++) {
                    char originalCh = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalCh) continue;
                        sb.setCharAt(i, c);
                        if (q2.contains(sb.toString())) return step + 1;
                        if (dict.contains(sb.toString())) {
                            String s2 = new String(sb);
                            newSet.add(s2);
                            dict.remove(s2);
                        }
                        sb.setCharAt(i, originalCh);
                    }
                }
            }
            step++;
            q1 = newSet;
        }
        return 0;
    }
}