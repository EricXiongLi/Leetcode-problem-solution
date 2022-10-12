class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] count = new int[2];
        count[1] = Integer.bitCount(num2);
        count[0] = 32 - count[1];
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int val = (num1 >> i) & 1;
            if (count[val] > 0) {
                count[val]--;
                if (val == 1) res += (1 << i);
            } else {
                int val2 = val ^ 1;
                count[val2]--;
                if (val2 == 1) res += (1 << i);
            }
        }
        return res;
    }
}