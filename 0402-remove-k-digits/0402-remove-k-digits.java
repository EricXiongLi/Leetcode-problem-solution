class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!dq.isEmpty() && dq.peek() > c && k > 0) {
                dq.pop();
                k--;
            }
            dq.push(c);
        }
        
        for (int i = 0; i < k; i++) {
            dq.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }
        while (sb.length() >= 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}