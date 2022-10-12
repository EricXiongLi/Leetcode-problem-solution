class Solution {
    public int minimizeXor(int num1, int num2) {
        int[] bit1 = new int[32], bit2 = new int[32];
        int[] freq = new int[2];
        for (int i = 0; i < 32; i++) {
            bit1[i] = (num1 >> i) & 1;
            bit2[i] = (num2 >> i) & 1;
            freq[bit2[i]]++;
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if (freq[bit1[i]] > 0) {
                if (bit1[i] == 1) res += (1 << i);
                freq[bit1[i]]--;
            } else {
                int val = 1 - bit1[i];
                if (val == 1) res += (1 << i);
                freq[val]--;
            }
        }
        return res;
    }
}