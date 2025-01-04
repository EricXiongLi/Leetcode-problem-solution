class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> res = new ArrayList<>();
        int flag = 1;
        int row = 0;
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }

        for (char c : s.toCharArray()) {
            res.get(row).append(c);
            row += flag;
            if (row == 0 || row == numRows - 1) {
                flag *= -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder sub : res) {
            sb.append(sub);
        }

        return sb.toString();
    }
}