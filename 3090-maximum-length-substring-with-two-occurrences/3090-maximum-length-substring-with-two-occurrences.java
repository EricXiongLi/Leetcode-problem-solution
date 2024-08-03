class Solution {
    public int maximumLengthSubstring(String s) {
        int start = 0;
        Map<Character, Integer> map = new HashMap();
        int res = Integer.MIN_VALUE;
        for (int end = 0; end < s.length(); end++) {
            map.putIfAbsent(s.charAt(end), 0);
            map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            while (map.get(s.charAt(end)) > 2) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}