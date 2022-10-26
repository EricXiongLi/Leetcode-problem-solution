class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        int targetCount = t.length();
        int minL = 0;
        int minLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        
        int l = 0;
        int count = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tmap.containsKey(c)) {
                if (smap.getOrDefault(c, 0) < tmap.get(c)) {
                    count++;
                }
                smap.put(c, smap.getOrDefault(c, 0) + 1);
            }
            while (count == targetCount) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minL = l;
                }
                char leftC = s.charAt(l);
                if (tmap.containsKey(leftC)) {
                    smap.put(leftC, smap.get(leftC) - 1);
                    if (smap.get(leftC) < tmap.get(leftC)) {
                        count--;
                    }
                    if (smap.get(leftC) == 0) smap.remove(leftC);
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen);
        
    }
}