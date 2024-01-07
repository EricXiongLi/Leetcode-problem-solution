class Solution {
    List<String> res = new LinkedList<>();
    
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder(), map);
        return res;
    }
    
    public void dfs(String digits, int pos, StringBuilder tmp, Map<Character, String> map) {
        
        if (pos == digits.length()) {
            res.add(new String(tmp));
            return;
        }
        
        char c = digits.charAt(pos);
        for (char cur : map.get(c).toCharArray()) {
            tmp.append(cur);
            dfs(digits, pos + 1, tmp, map);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

}