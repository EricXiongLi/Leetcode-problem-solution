class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(0, s, new String(), ans);
        return ans;
    }
    
    private void dfs(int d, String s, String ip, List<String> ans) {
        //base case
        int l = s.length();
        if (d == 4) {
            if (l == 0) {
                ans.add(new String(ip));
            }
            return;
        }
        if (l == 0) {
            return;
        }
        
        //recursive steps
        for (int i = 1; i <= Math.min(3, s.charAt(0) == '0' ? 1 : l); i++) {
            String ss = s.substring(0, i);
            if (i == 3 && Integer.valueOf(ss) > 255) {
                return;
            }
            
            dfs(d + 1, s.substring(i), ip + (d == 0 ? "" : ".") + ss, ans);
        }
    }
}

//tc: O(3 ^ 4)

//sc: O(1)