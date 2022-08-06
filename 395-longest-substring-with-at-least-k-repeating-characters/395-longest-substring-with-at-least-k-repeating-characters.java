class Solution {
    public int longestSubstring(String s, int k) {
        int res = Integer.MIN_VALUE;
        for (int unique = 1; unique <= s.length() / k; unique++) {
            int left = 0;
            Map<Character, Integer> map = new HashMap<>();
            int validCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) validCount++;
                while (map.keySet().size() > unique) {
                    char leftChar = s.charAt(left);
                    if (map.get(leftChar) == k) validCount--;
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
                int count = map.keySet().size();
                if (count == validCount) res = Math.max(res, i - left + 1);
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}