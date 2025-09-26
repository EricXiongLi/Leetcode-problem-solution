class Solution {
    Map<Character, String> map1;
    Map<String, Character> map2;
    public boolean wordPatternMatch(String pattern, String s) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        return backtracking(pattern, 0, s, 0);
    }

    public boolean backtracking(String pattern, int pIndex, String s, int sIndex) {
        if (pIndex == pattern.length()) {
            return s.length() == sIndex;
        }

        char pChar = pattern.charAt(pIndex);
        //case 1: pattern[p] is already mapped
        if (map1.containsKey(pChar)) {
            String target = map1.get(pChar);

            if (!s.startsWith(target, sIndex)) {
                return false;
            }

            return backtracking(pattern, pIndex + 1, s, sIndex + target.length());
        }

        //case 2: pattern[p] is not mapped yet
        int requireLeftLength = 0;

        for (int i = pIndex + 1; i < pattern.length(); i++) {
            requireLeftLength += map1.containsKey(pattern.charAt(i)) ? map1.get(pattern.charAt(i)).length() : 1;
        }

        for (int i = sIndex + 1; i <= s.length() - requireLeftLength; i++) {
            String subS = s.substring(sIndex, i);
            //[sIndex: i - 1]
            if (map2.containsKey(subS)) continue;
            map1.put(pChar, subS);
            map2.put(subS, pChar);
            if (backtracking(pattern, pIndex + 1, s, i)) {
                return true;
            }
            map1.remove(pChar);
            map2.remove(subS);
        }

        return false;
    }
}