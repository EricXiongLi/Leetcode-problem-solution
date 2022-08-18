class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length();
        end--;
        while (s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}