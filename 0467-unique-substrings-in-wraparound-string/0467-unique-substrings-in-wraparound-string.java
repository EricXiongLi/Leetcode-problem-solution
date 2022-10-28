class Solution {
    //'a' - 'z' = 65 - 90 = -25
    public int findSubstringInWraproundString(String p) {
        int count = 0;
        int pre = 0;
        int n = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (i != 0 && (p.charAt(i) - p.charAt(i - 1) == -25 || p.charAt(i) - p.charAt(i - 1) == 1)) {
                pre += 1;
            } else {
                pre = 1;
            }
            map.put(c, Math.max(pre, map.getOrDefault(c, 0)));
        }
        return map.values().stream().mapToInt(i -> i).sum();
    }
}