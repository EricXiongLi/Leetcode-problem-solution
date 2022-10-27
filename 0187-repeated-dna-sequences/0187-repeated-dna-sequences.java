class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> res = new HashSet<>();
        int n = s.length();
        for (int l = 0; l + 10 <= n; l++) {
            String cur = s.substring(l, l + 10);
            if (!visited.add(cur)) {
                res.add(cur);
            }
        }
        return new ArrayList<String>(res);
    }
}