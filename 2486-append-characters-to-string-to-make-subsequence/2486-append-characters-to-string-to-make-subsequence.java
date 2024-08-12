class Solution {
    public int appendCharacters(String s, String t) {
        int p2 = 0;
        int n1 = s.length(), n2 = t.length();
        int commonLength = 0;
        for (int p1 = 0; p1 < n1; p1++) {
            if (p2 < n2 && s.charAt(p1) == t.charAt(p2)) {
                commonLength++;
                p2++;
            }
        }
        
        return n2 - commonLength;
    }
}

//tc: O(n)
//sc: O(1)