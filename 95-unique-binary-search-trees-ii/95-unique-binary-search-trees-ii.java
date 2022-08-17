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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++) {
            TreeNode root = new TreeNode(i);
            for (TreeNode leftNode : dfs(start, i - 1)) {
                root.left = leftNode;
                for (TreeNode rightNode : dfs(i + 1, end)) {
                    root.right = rightNode;
                    res.add(root);
                    root = new TreeNode(i);
                    root.left = leftNode;
                }
            }
        }
        return res;
    }
    
    
    
}