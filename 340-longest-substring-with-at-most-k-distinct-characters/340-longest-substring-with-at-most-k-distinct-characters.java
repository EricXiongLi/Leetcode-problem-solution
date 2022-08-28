class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();//< char, frequency>
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            map.put(r, map.getOrDefault(r, 0) + 1);
            while (map.size() > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if (map.get(l) == 0) {
                    map.remove(l);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}