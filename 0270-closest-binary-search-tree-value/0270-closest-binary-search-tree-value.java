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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target) || (Math.abs(root.val - target) == Math.abs(res - target) &&  root.val < res)) {
                res = root.val;
            }

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }
    
    //seek for closest value;
    
}

//tc: O(h)
//sc: O(h) -> O(n)