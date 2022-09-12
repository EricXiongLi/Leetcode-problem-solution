class Solution {
    public String reorganizeString(String s) {
        //aab
        //a:2, b:1
       //aba
        //aaabb
        //(n + 1) / 2
        int[] count = new int[26];
        int maxIndex = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                maxIndex = c - 'a';
                max = count[c - 'a'];
            }
        }
        System.out.println(Arrays.toString(count));
        int n = s.length();
        char[] res = new char[n];
        int start = 0;
        if (max > (n + 1) / 2) {
            return "";
        }
        while (count[maxIndex] > 0) {
            res[start] = (char) (maxIndex + 'a');
            count[maxIndex]--;
            start += 2;
        }
        
        if (start >= n) {
            start = 1;
        }
        //aa
        //ababdc
        
        //aaabbdd
        //abadadb
        
        //vlvov
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                res[start] = (char) (i + 'a');
                count[i]--;
                start += 2;
                if (start >= n) {
                    start = 1;
                }
            }
        }
        return new String(res);
        
    }
}