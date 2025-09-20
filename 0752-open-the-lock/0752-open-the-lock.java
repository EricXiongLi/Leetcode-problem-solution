class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer("0000");
        visited.add("0000");
        if (target.equals("0000")) return 0;
        if (dead.contains("0000") && !target.equals("0000")) return -1;
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur, j);
                    String minus = minusOne(cur, j);
                    if (plus.equals(target) || minus.equals(target)) {
                        return step + 1;
                    }

                    if (!visited.contains(plus) && !dead.contains(plus)) {
                        visited.add(plus);
                        q.offer(plus);
                    }

                    if (!visited.contains(minus) && !dead.contains(minus)) {
                        visited.add(minus);
                        q.offer(minus);
                    }
                    
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int j) {
        char[] chs = s.toCharArray();

        if (chs[j] == '9') {
            chs[j] = '0';
        } else {
            chs[j] += 1;
        }

        return new String(chs);
    }

    public String minusOne(String s, int j) {
        char[] chs = s.toCharArray();
        if (chs[j] == '0') {
            chs[j] = '9';
        } else {
            chs[j] -= 1;
        }

        return new String(chs);
    }
}

//tc: O(10 ^ 4)
//sc: O(10^4)