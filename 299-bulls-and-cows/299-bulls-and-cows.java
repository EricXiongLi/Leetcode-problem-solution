class Solution {
    public String getHint(String secret, String guess) {
        int[] h = new int[10];
        int n = secret.length();
        int bull = 0, cow = 0;
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bull++;
            } else {
                if (h[g - '0'] < 0) {
                    cow++;
                }
                if (h[s - '0'] > 0) {
                    cow++;
                }
                h[g - '0']++;
                h[s - '0']--;
            }
        }
        StringBuilder res = new StringBuilder();
        
        res.append(bull);
        res.append('A');
        
        res.append(cow);
        res.append('B');
        return res.toString();
    }
}