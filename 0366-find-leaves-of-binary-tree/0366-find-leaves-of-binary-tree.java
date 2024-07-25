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
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        return res;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        int curHeight = Math.max(lHeight, rHeight) + 1;
        if (res.size() <= curHeight) {
            res.add(new ArrayList<Integer>());
        }
        res.get(curHeight).add(root.val);
        return curHeight;
    }
}