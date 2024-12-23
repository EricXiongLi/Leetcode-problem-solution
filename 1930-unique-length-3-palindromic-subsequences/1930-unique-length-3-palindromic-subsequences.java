class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first.containsKey(c)) {
                last.put(c, i);
            } else {
                first.put(c, i);
            }
        }
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int l = first.getOrDefault(c, -1);
            int r = last.getOrDefault(c, -1);
            Set<Character> set = new HashSet<>();
            if (l != -1 && r != -1) {
                for (int i = l + 1; i <= r - 1; i++) {
                    set.add(s.charAt(i));
                }
                res += set.size();
                set.clear();
            }
        }

        return res;
    }
}