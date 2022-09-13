class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }
    
    private int countPalindrome(String s, int l, int r) {
        int count = 0;
        int n = s.length();
        char lC, rC;
        while (l >= 0 && r < n) {
            lC = s.charAt(l);
            rC = s.charAt(r);
            if (lC == rC) {
                count++;
            } else {
                break;
            }
            l--;
            r++;
        }
        return count;
    }
}