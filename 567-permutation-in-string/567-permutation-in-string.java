class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] target = new int[26];
        int[] cur = new int[26];
        if (m > n) return false;
        for (int i = 0; i < m; i++) {
            target[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            cur[s2.charAt(i) - 'a']++;
        }
        if (check(target, cur)) return true;
        for (int j = m; j < n; j++) {
            cur[s2.charAt(j) - 'a']++;
            cur[s2.charAt(j - m) - 'a']--;
            if (check(target, cur)) return true;
        }
        
        return false;
        
    }
    
    private boolean check(int[] target, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (target[i] != cur[i]) return false;
            
        }
        return true;
    }
}

//tc:O(26 * n * n)
//sc: O(m);