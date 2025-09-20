class Solution {
    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        backtracking(map, digits, 0, sb);

        return res;
    }

    public void backtracking(Map<Character, String> map, String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(new String(sb));
            return;
        }

        for (char c : map.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            backtracking(map, digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}