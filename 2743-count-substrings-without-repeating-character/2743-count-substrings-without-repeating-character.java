class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int[] freq = new int[26];
        int count = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq[c - 'a']++;
            while (freq[c - 'a'] > 1) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }
            //the num of appropriate subarray ending with char at end
            count += (end - start + 1);
        }
        
        return count;
    }
}

//tc: O(n)
//sc: O(1)