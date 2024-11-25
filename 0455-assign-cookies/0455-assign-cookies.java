class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p0 = 0, p1 = 0;
        int count = 0;
        while (p0 < g.length) {
            while (p1 < s.length && g[p0] > s[p1]) {
                p1++;
            }
            if (p1 < s.length && g[p0] <= s[p1]) {
                p1++;
                count++;
            }
            p0++;
        }
        
        return count;
    }
}