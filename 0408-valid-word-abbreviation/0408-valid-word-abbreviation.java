class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c1 = word.charAt(i);
            char c2 = abbr.charAt(j);
            
            if (c1 == c2) {
                i++;
                j++;
                continue;
            }
            if (c2 > '9' || c2 <= '0') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            int val = Integer.valueOf(abbr.substring(start, j));
            i += val;
        }
        return i == word.length() && j == abbr.length();
    }
}