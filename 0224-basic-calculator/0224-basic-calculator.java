class Solution {
    public int calculate(String s) {
        Map<Integer, Integer> nextBracket = new HashMap();
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                nextBracket.put(stack.pop(), i);
            }
        }
        
        return (int)calculate(s, 0, s.length() - 1, nextBracket);
    }
    
    public long calculate(String s, int start, int end, Map<Integer, Integer> nextBracket) {
        if (start == end) {
            return (int)(s.charAt(start) - '0');
        }
        long sum = 0;
        int num = 0;
        //plus or minus
        int flag = 1;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                while (i <= end && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = 10 * num + (int)(s.charAt(i) - '0');
                    i++;
                }
                i--;
                sum = sum + flag * num;
                num = 0;
                flag = 1;
            } else if (c == '-') {
                flag = -1;
            } else if (c == '+') {
                continue;
            } else if (c == '(') {
                sum += flag * calculate(s, i + 1, nextBracket.get(i) - 1, nextBracket);
                flag = 1;
                i = nextBracket.get(i);
            }
        }
        return sum;
    }
}