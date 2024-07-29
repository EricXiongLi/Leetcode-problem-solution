class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap();
        int n = recipes.length;
        Map<String, Integer> indegree = new HashMap();
        
        for (int i = 0; i < n; i++) {
            List<String> ingredient = ingredients.get(i);
            for (String item : ingredient) {
                graph.computeIfAbsent(item, v -> new ArrayList<String>()).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        
        List<String> res = new ArrayList();
        Queue<String> q = new ArrayDeque();
        
        for (String s : supplies) {
            q.offer(s);
        }
        
        while(!q.isEmpty()) {
            String cur = q.poll();
            for (String nei : graph.getOrDefault(cur, new ArrayList<String>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    res.add(nei);
                    q.offer(nei);
                }
            }
        }
        
        return res;
        
    }
}

//tc: O(n)
//sc: O(n)