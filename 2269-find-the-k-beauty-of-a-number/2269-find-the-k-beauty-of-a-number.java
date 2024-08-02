class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int l = 0;
        int count = 0;
        for (int r = 0; r < s.length(); r++) {
            while (r - l + 1 > k) {
                l++;
            }
            String sub = s.substring(l, r+ 1);
            if (r - l + 1 == k && Integer.valueOf(sub) != 0 && num % (Integer.valueOf(sub)) == 0) {
                count++;
            }
        }
        return count;

    }
}

//tc: O(n)
//sc: O(n)