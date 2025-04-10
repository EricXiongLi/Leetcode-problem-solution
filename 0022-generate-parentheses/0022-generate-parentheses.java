class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, ans, new StringBuilder(), n);
        return ans;
    }
    
    private void dfs(int open, int close, List<String> ans, StringBuilder subAns, int n) {
        if (open == n && close == n) {
            ans.add(new String(subAns));
            return;
        }
        
        if (open == 0) {
            subAns.append('(');
            dfs(open + 1, close, ans, subAns, n);
            subAns.deleteCharAt(subAns.length() - 1);
        } else if (open == n) {
            subAns.append(')');
            dfs(open, close + 1, ans, subAns, n);
            subAns.deleteCharAt(subAns.length() - 1);
        } else if (open > close) {
            subAns.append('(');
            dfs(open + 1, close, ans, subAns, n);
            subAns.deleteCharAt(subAns.length() - 1);
            subAns.append(')');
            dfs(open, close + 1, ans, subAns, n);
            subAns.deleteCharAt(subAns.length() - 1);
        } else {
            subAns.append('(');
            dfs(open + 1, close, ans, subAns, n);
            subAns.deleteCharAt(subAns.length() - 1);
        }
    }
}

//tc: O(2 ^ n)
//sc: O(n)