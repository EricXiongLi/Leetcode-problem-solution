class Solution {
    List<String> res = new LinkedList<>();
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(digits, 0, new StringBuilder());
        return res;
    }

    public void backtracking(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(new String(sb));
            return;
        }
        String options = map.get(digits.charAt(i));

        for (char c : options.toCharArray()) {
            sb.append(c);
            backtracking(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}