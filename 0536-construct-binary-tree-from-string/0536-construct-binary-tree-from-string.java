/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        int i = 0;
        int sign = 1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = null, par = null;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ')') {
                cur = stack.pop();
                par = stack.peek();
                if (par.left == null) {
                    par.left = cur;
                } else {
                    par.right = cur;
                }
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            } else if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                
                
                stack.push(new TreeNode(sign * num));
                sign = 1;
            } else {
                i++;
            }
        }
        
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        
        return par;
    }
}