class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        Set<String> dict = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) return 0;
        
        q1.offer(beginWord);
        q2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int level = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Switch to the smaller queue
            Queue<String> q;
            Set<String> visited, otherVisited;
            if (q1.size() <= q2.size()) {
                q = q1;
                visited = visited1;
                otherVisited = visited2;
            } else {
                q = q2;
                visited = visited2;
                otherVisited = visited1;
            }
            
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] chs = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char ch = chs[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch != c) {
                            chs[j] = c;
                            String nei = new String(chs);
                            if (otherVisited.contains(nei)) {
                                return level + 1;
                            }
                            if (dict.contains(nei) && !visited.contains(nei)) {
                                visited.add(nei);
                                q.offer(nei);
                            }
                            chs[j] = ch;
                        }
                    }
                }
            }
        }

        return 0;
    }
}