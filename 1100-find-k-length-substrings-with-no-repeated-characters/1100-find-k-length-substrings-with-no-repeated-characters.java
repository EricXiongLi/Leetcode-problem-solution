class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int start = 0;
        //value -> count: in the current window
        Map<Character, Integer> freq = new HashMap();
        int res = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.get(c) > 1) {
                char startChar = s.charAt(start);
                freq.put(startChar, freq.get(startChar) - 1);
                start++;
            }
            if (end - start + 1 == k) {
                res++;
                freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
                start++;
            } 
        }
        
        return res;
    }
}