class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gp = 0, sp = 0, res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gp < g.length && sp < s.length) {
            if (s[sp] >= g[gp]) {
                res++;
                gp++;
            }
            sp++;
        }
        return res;
    }
}