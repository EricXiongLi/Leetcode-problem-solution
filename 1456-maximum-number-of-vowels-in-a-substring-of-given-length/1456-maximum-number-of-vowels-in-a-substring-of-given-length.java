class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (set.contains(s.charAt(end))) {
                count++;
            }
            while (end - start + 1 > k) {
                if (set.contains(s.charAt(start))) {
                    count--;
                }
                start++;
            }
            
            if (end - start + 1 == k) {
                res = Math.max(res, count);
            }
            
        }
        
        return res;
    }
}