class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int targetCount = t.length();
        int resL = -1;
        int resR = 100001;
        int l = 0;
        int count = 0;

        Map<Character, Integer> cur = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tmap.containsKey(c)) {
                if (cur.getOrDefault(c, 0) < tmap.get(c)) {
                    count++;
                }
                cur.put(c, cur.getOrDefault(c, 0) + 1);
            }
            while (count >= targetCount) {
                if (r - l < resR - resL) {
                    resL = l;
                    resR = r;
                }
                char leftC = s.charAt(l);
                if (tmap.containsKey(leftC)) {
                    if (cur.get(leftC) <= tmap.get(leftC)) {
                        count--;
                    }
                    cur.put(leftC, cur.get(leftC) - 1);
                    if (cur.get(leftC) == 0) {
                        cur.remove(leftC);
                    }
                }
                l++;
            }
        }

        if (resL == -1) return "";
        return s.substring(resL, resR + 1);
    }
}