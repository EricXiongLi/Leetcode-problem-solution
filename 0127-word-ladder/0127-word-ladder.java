class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        Set<String> visited = new HashSet<>();
        
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        q1.offer(beginWord);
        q2.offer(endWord);
        
        visited.add(beginWord);
        visited.add(endWord);
        
        int step = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Queue<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
            int sz =  q1.size();
            for (int i = 0; i < sz; i++) {
                char[] cur = q1.poll().toCharArray();
                
                for (int j = 0; j < cur.length; j++) {
                    char origin = cur[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != origin) {
                            cur[j] = c;
                        String tmp = new String(cur);
                        
                        if (q2.contains(tmp)) {
                            return step + 1;
                        }
                        
                        if (!visited.contains(tmp) && dict.contains(tmp)) {
                            visited.add(tmp);
                            q1.offer(tmp);
                        }
                        }
                    }
                    cur[j] = origin;
                }
            }
            step++;
        }
        
        return 0;
    }
}