class Solution {
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int start = 0, end = res.length - 1;
        while (start < end) {
            while (start < end && !isVowel(res[start]) ) {
                start++;
            }
            while (end > 0 && !isVowel(res[end])) {
                end--;
            }
            if (start < end) {
                char temp = res[start];
            res[start] = res[end];
            res[end] = temp;
            start++;
            end--;
            }
        }
        return new String(res);
    }
    
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}

//tc: O(n)
//sc: O(n)