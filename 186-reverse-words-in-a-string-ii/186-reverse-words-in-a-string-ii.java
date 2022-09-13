class Solution {
    public void reverseWords(char[] s) {
        //the,_, sky,_, applewatch
       reverse(0, s.length - 1, s);
        int pointer = -1;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == ' ') {
                reverse(pointer + 1, i - 1, s);
                pointer = i;
            }
        }
        reverse(pointer + 1, s.length - 1, s);
    }
    
    private void reverse(int l, int r, char[] s) {
        while (l < r) {
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }
}