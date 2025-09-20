class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}