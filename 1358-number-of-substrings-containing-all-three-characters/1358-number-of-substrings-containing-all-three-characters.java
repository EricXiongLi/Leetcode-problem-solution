class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0;
        int[] count = new int[3];
        int res = 0;
        
        for (int end = 0; end < n; end++) {
            char c= s.charAt(end);
            count[c - 'a']++;
            while (count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                res += (n - end);
                char toBeRemoved = s.charAt(start);
                count[toBeRemoved - 'a']--;
                start++;
            }
        }
        
        return res;
    }
}