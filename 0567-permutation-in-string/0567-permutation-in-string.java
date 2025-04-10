class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int count = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            if (map1.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map2.get(c).equals(map1.get(c))) {
                    count++;
                }
            }
            while (r - l + 1 > s1.length()) {
                char leftC = s2.charAt(l);
                if (map1.containsKey(leftC)) {
                    if (map2.get(leftC).equals(map1.get(leftC))) {
                        count--;
                    }
                    map2.put(leftC, map2.get(leftC) - 1);
                    if (map2.get(leftC) == 0) {
                        map2.remove(leftC);
                    }
                }
                l++;
            }
            if (r - l + 1 == s1.length() && count == map1.size()) {
                return true;
            } 
        }
        return false;
    }

}