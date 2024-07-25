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
    String minString = "";
    
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return minString;
    }
    
    public void dfs(TreeNode node, String cur) {
        if (node == null) return;
        
        String newString = (char)(node.val + 'a') + cur;
        if (node.left == null && node.right == null) {
            if (minString.isEmpty() || minString.compareTo(newString) > 0) {
                minString = newString;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, newString);
        }
        if (node.right != null) {
            dfs(node.right, newString);
        }
        
    }
}

//tc: O(n * n)
//sc: O(n * n)