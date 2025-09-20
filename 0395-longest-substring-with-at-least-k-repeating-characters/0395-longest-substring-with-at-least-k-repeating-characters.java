class Solution {
    public int longestSubstring(String s, int k) {
        int res = Integer.MIN_VALUE;

        for (int unique = 1; unique <= s.length()/k; unique++) {
            Map<Character, Integer> freq = new HashMap<>();

            int validUnique = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);

                freq.put(c, freq.getOrDefault(c, 0) + 1);
                if (freq.get(c) == k) {
                    validUnique++;
                }

                while (freq.size() > unique) {
                    char leftChar = s.charAt(l);
                    if(freq.get(leftChar) == k) {
                        validUnique--;
                    }
                    freq.put(leftChar, freq.get(leftChar) - 1);
                    if(freq.get(leftChar) == 0) {
                        freq.remove(leftChar);
                    }
                    l++;
                }

                if(validUnique == unique) {
                    res = Math.max(res, r - l + 1);
                }
            }

        }
        return res;
    }
}