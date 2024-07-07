class Solution {
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String toGoatLatin(String sentence) {
        String[] ss = sentence.split(" ");
        int n = ss.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String transformed = transform(ss[i], i + 1);
            res.append(transformed);
            if (i != n - 1) {
                res.append(" ");
            }
        }
        
        return res.toString();
    }
    
    public String transform(String s, int count) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(0);
        if (set.contains(c)) {
            sb.append("ma");
        } else {
            sb.deleteCharAt(0);
            sb.append(c);
            sb.append("ma");
        }
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}