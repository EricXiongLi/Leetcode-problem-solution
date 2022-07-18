class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue();
            }
        });
            Map<String, Integer> hm = new HashMap<>();
        for (String s: words) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> e: hm.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }
        
        List<String> ans = new LinkedList<>();
        while (pq.size() != 0) {
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
            
    }
}