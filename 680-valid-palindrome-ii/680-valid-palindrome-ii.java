class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start >= end) return true;
        return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//tc:O(n)
//sc:O(1)