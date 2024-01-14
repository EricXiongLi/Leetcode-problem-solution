class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (source == destination) {
            return true;
        }
        for (int[] edge : edges) {
            int start = edge[0], end=edge[1];
            map.computeIfAbsent(start, v -> new ArrayList<>()).add(end);
            map.computeIfAbsent(end, v -> new ArrayList<>()).add(start);
        }
        Set<Integer> visited = new HashSet<>();
        
        for (int nei : map.getOrDefault(source, new ArrayList<>())) {
            visited.add(nei);
            if (dfs(nei, map, visited, destination)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int source, Map<Integer, List<Integer>> map, Set<Integer> visited, int destination) {
        if (source == destination) {
                return true;
        }
        for (int nei : map.getOrDefault(source, new ArrayList<>())) {
            if (!visited.contains(nei)) {
                visited.add(nei);
                if (dfs(nei, map, visited, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}

//tc: O(n)
//sc: O(n)