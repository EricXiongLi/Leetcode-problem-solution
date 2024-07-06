class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int size = sb.length();
            if (sb.length() == 0 || sb.charAt(size - 1) != c) {
                sb.append(c);
            } else if (sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            }
        }
        
        return sb.toString();
    }
}

//tc: O(N)
//sc: O(N - D): D is the length of duplicate chars