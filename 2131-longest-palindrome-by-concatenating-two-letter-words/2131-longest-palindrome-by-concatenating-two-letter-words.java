class Solution {
    public int longestPalindrome(String[] words) {
        int[][] arr = new int[26][26];
        int count = 0;
        for (String s : words) {
            char c1 = s.charAt(0), c2 = s.charAt(1);
            if (arr[c2 - 'a'][c1 - 'a'] > 0) {
                count += 4;
                arr[c2 - 'a'][c1 - 'a']--;
            } else {
                arr[c1 - 'a'][c2 - 'a']++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (arr[i][i] > 0) {
                count += 2;
                break;
            }
        }
        
        return count;
    }
}