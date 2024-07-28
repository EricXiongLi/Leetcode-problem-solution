class Solution {
    public List<String> validStrings(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1");
        }
        
        List<String> res = new ArrayList();
        
        for (String s : validStrings(n - 1)) {
            if (s.endsWith("1")) {
                res.add(s + "0");
            }
            res.add(s + "1");
        }
        return res;
    }
}