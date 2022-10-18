class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        
        res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, List<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        dfs(sb, digits, 0, map);
        return res;
    }
    
    private void dfs(StringBuilder sb, String s, int index, Map<Character, List<Character>> map) {
        if (index == s.length()) {
            res.add(new String(sb));
            return;
        }
        for (char c : map.get(s.charAt(index))) {
            sb.append(c);
            dfs(sb, s, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}