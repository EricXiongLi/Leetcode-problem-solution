class Solution {
    Map<Integer, Integer> nextBracket = new HashMap();
    public String decodeString(String s) {
        
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if (s.charAt(i) == ']') {
                int left = stack.pop();
                nextBracket.put(left, i);
            }
        }
        return decode(s, 0, s.length() - 1).toString();
    }
    
    public StringBuilder decode(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        if (start == end) {
            sb.append(s.charAt(start));
            return sb;
        }
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (int)(c - '0');
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '[') {
                for (int j = 0; j < num; j++) {
                    StringBuilder subSb = decode(s, i + 1, nextBracket.get(i) - 1);
                    sb.append(subSb);
                }
                num = 0;
                i = nextBracket.get(i);
            }
        }
        return sb;
    }
}