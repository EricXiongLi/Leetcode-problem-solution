class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int a = Character.getNumericValue(num1.charAt(i));
                int b = Character.getNumericValue(num2.charAt(j));
                int c = a * b;
                int pos1 = l1 - 1 - i;
                int pos2 = l2 - 1 - j;
                ans[pos1 + pos2] += c;
                ans[pos1 + pos2 + 1] += ans[pos1 + pos2] / 10;
                ans[pos1 + pos2] %= 10;
            }
        }
        String s = new String();
        for (int i = ans.length - 1; i >= 0; i--) {
            if (i == ans.length - 1 && ans[i] == 0) continue;
            s += ans[i];
        }
        return s;
    }
}