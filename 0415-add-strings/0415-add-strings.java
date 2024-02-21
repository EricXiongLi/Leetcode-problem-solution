class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        
        int p1 = n1 - 1, p2 = n2 - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (p1 != -1 || p2 != -1) {
            int curInt1 = p1 == -1 ? 0:  num1.charAt(p1--) - '0';
            int curInt2 = p2 == -1 ? 0: num2.charAt(p2--) - '0';
            int curSum = curInt1 + curInt2 + carry;
            sb.append(curSum % 10);
            carry = curSum >= 10 ? 1 : 0;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}