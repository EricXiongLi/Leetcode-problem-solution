class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'A']++;            
            while (i - left + 1 - findMax(count) > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    
    public int findMax(int[] count) {
        return Arrays.stream(count).max().getAsInt();
    }
}