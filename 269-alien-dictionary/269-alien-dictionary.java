class Solution {
    public String alienOrder(String[] words) {
        int n = words.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> hs = new HashSet<>();
        int[] indegree = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                hs.add(c - 'a');
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int p1 = 0, p2 = 0;
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) return "";
            char c1 = words[i].charAt(p1), c2 = words[i + 1].charAt(p2);
            while (c1 == c2 && p1 < words[i].length() && p2 < words[i + 1].length()) {
                c1 = words[i].charAt(p1);
                c2 = words[i + 1].charAt(p2);
                p1++;
                p2++;
            }
            if (c1 == c2) {
                continue;
            }
            hs.add(c1 - 'a');
            hs.add(c2 - 'a');
            graph.computeIfAbsent(c1 - 'a', v -> new ArrayList<Integer>()).add(c2 - 'a');
            indegree[c2 - 'a']++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26 ;i++) {
            if (indegree[i] == 0 && hs.contains(i)) {
                q.offer(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                char c = (char) (cur + 'a');
                res.append(c);
                for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        return res.length() == hs.size() ? res.toString() : "";
    }
}