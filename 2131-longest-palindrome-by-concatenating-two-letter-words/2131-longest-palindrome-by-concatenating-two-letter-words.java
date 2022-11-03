class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int count = 0;
        for (String s: words) {
            if (s.charAt(0) == s.charAt(1)) {
                if (map2.containsKey(s)) {
                    count += 4;
                    map2.put(s, map2.get(s) - 1);
                    if (map2.get(s) == 0) {
                        map2.remove(s);
                    }
                } else {
                    map2.put(s, map2.getOrDefault(s, 0) + 1);
                }
            } else {
                String target = new StringBuilder(s).reverse().toString();
                if (map1.containsKey(target)) {
                    count += 4;
                    map1.put(target, map1.get(target) - 1);
                    if (map1.get(target) == 0) map1.remove(target);
                } else {
                    map1.put(s, map1.getOrDefault(s, 0) + 1);
                }
            }
        }
        if (!map2.isEmpty()) {
            count += 2;
        }
        return count;
    }
}