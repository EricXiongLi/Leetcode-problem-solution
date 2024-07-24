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
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    
    //the left balance at the position "node" (already make left child tree and right child and the node itself complete filled with 1)
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val1 = dfs(node.left);
        int val2 = dfs(node.right);
        int balance = node.val + val1 + val2 - 1;
        res += Math.abs(val1) + Math.abs(val2);
        return balance;
    }
}

//tc: O(n)
//sc: O(n)