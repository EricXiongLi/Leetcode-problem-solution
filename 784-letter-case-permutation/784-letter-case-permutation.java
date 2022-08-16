class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s.toCharArray(), new StringBuilder(), 0);
        return res;
    }
    
    private void dfs(List<String> res, char[] chs, StringBuilder sb, int i) {
        if (i == chs.length) {
            res.add(sb.toString());
            return;
        }
        
        if (Character.isDigit(chs[i])) {
            sb.append(chs[i]);
            dfs(res, chs, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(chs[i]);
            dfs(res, chs, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
            chs[i] ^= (1 << 5);
            sb.append(chs[i]);
            dfs(res, chs, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
            chs[i] ^= (1 << 5);
        }
    }
}