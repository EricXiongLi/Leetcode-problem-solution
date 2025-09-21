class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (t.equals(s)) return false;

        int p1 = 0, p2 = 0;
        int balance = 1;

        while (p1 < l1 || p2 < l2) {
            if ((p1 < l1 && p2 < l2 && s.charAt(p1) != t.charAt(p2)) || (p1 >= l1) || (p2 >= l2)) {
                if (balance == 1) {
                    if (l1 < l2) {
                        p2++;
                    } else if (l1 > l2) {
                        p1++;
                    } else {
                        p1++;
                        p2++;
                    }
                    balance = 0;
                } else {
                    return false;
                }
            } else {
                p1++;
                p2++;
            }
        }

        return true;
    }
}