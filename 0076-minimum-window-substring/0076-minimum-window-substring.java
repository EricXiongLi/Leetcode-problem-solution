class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(); // <char, times it appears>
        Map<Character, Integer> tMap = new HashMap<>();
        int targetCount = 0, count = 0, left = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            targetCount++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                if (map.getOrDefault(c, 0) < tMap.get(c)) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    count++;
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            while (count >= targetCount) {
                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) < tMap.get(leftChar)) {
                        count--;
                    }
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }
}