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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {  
        int path = 0;
        dfs(root, path);
        return count;
    }
    
    public void dfs(TreeNode node, int path) {
        path ^= (1 << node.val);
        
        if (node.left == null && node.right == null) {
            if ((path & (path - 1)) == 0) {
                count++;
                System.out.println(node.val);
            }
            return;
        }
        
        if (node.left != null) {
            dfs(node.left, path);
        }
        
        if (node.right != null) {
            dfs(node.right, path);
        }
        //revoke the change made to path: no need, int is pass by value in java
        
    }
}

//tc: O(n)
//sc: O((logN), n in the word case)