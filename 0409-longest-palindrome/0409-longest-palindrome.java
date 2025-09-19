class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean containsOdd = false;
        int res = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                if (containsOdd) {
                    res += map.get(c) - 1;
                } else {
                    res += map.get(c);
                    containsOdd = true;
                }
            } else {
                res += map.get(c);
            }
        }

        return res;
    }
}