class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int n = s.length();
        int res = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
                if (map.get(left) == 0) map.remove(left);
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}