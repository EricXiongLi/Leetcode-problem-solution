class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> count = new HashMap();
        int start = 0;
        int res = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while (count.size() > 2) {
                char leftChar = s.charAt(start);
                count.put(leftChar, count.get(leftChar) - 1);
                if (count.get(leftChar) == 0) {
                    count.remove(leftChar);
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}