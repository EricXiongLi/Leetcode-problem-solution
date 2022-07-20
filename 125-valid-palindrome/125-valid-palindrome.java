class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end > 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start < end) {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            }
            
            start++;
            end--;
        }
        return true;
    }
}

//tc: O(n)
//sc: O(1)