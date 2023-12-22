class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char right = s.charAt(r);
            
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.size() > k) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
            
        }
        return res;
    }
}