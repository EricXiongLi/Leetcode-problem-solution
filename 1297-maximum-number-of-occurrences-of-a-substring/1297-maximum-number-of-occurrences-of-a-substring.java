class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < minSize; i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        if (map1.size() <= maxLetters) {
            String cur = s.substring(0, minSize);
            map2.put(cur, map2.getOrDefault(cur, 0) + 1);
        }
        System.out.println("first map2:" + map2);
        int l = 0;
        int n = s.length();
        for (int r = minSize; r < n; r++) {
            char cLeft = s.charAt(l);
            map1.put(cLeft, map1.get(cLeft) - 1);
            if (map1.get(cLeft) == 0) map1.remove(cLeft);
            l++;
            char cRight = s.charAt(r);
            map1.put(cRight, map1.getOrDefault(cRight, 0) + 1);
            
            if (map1.size() <= maxLetters) {
                String cur = s.substring(l, r + 1);
                map2.put(cur, map2.getOrDefault(cur, 0) + 1);
            }
        }
        System.out.println("map2:" + map2);
        if (map2.isEmpty()) return 0;
        return map2.values().stream().mapToInt(i -> i).max().getAsInt();
    }
}