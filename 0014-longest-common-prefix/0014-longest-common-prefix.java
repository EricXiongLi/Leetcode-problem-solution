class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            
            for (String str : strs) {
                if (str.length() == i || str.charAt(i) != c) {
                    return res.substring(0, i);
                }
            }
        }
        
        return res;
    }
}

//tc: O(n)

//sc: O(1)