class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 1;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char leftC = s.charAt(l);
                map.put(leftC, map.get(leftC) - 1);
                if (map.get(leftC) == 0) map.remove(leftC);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}