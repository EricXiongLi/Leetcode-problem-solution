class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();
        
        while (p1 < Math.max(n1, n2) && p2 < Math.max(n1, n2)) {
            int a = 0;
            while (p1 < n1 && version1.charAt(p1) != '.') {
                a = 10 * a + version1.charAt(p1) - '0';
                p1++;
            }
            int b = 0;
            while (p2 < n2 && version2.charAt(p2) != '.') {
                b = 10 * b + version2.charAt(p2) - '0';
                p2++;
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            p1++;
            p2++;
        }
        
        return 0;
    }
}