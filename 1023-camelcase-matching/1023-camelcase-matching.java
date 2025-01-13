class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            res.add(canMatch(q, pattern));
        }
        return res;
    }

    public boolean canMatch(String s, String pattern) {
        
        int p0 = 0, p1 = 0;
        while (p0 < s.length() && p1 < pattern.length()) {
            if (s.charAt(p0) == pattern.charAt(p1)) {
                p0++;
                p1++;
            } else {
                char c0 = s.charAt(p0);
                char c1 = pattern.charAt(p1);
                //c0: upper, c1: lower: false
                //c0: upper, c1: upper: false
                //c0: lower, c1: upper: p0++
                //c0: lower, c1: lower: p0++
                if (Character.isUpperCase(c0)) {
                    return false;
                } else {
                    p0++;
                }
            }
        }

        if (p1 == pattern.length()) {
            for (int i = p0; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}