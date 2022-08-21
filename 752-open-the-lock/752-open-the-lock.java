class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadEnds = new HashSet<>();
        for (String s : deadends) {
            deadEnds.add(s);
        }
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deadEnds.contains(cur)) continue;
                if (cur.equals(target)) return level;
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur, j);
                    String minus = minusOne(cur, j);
                    if (!visited.contains(plus)) {
                            visited.add(plus);
                            q.offer(plus);
                    }
                    if (!visited.contains(minus)) {
                        visited.add(minus);
                        q.offer(minus);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private String plusOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '9') {
            chs[i] = '0';
        } else {
            chs[i] += 1;
        }
        return new String(chs);
    }
    
    private String minusOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '0') {
            chs[i] = '9';
        } else {
            chs[i] -= 1;
        }
        return new String(chs);
    }
}