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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap();
        HashMap<TreeNode, Integer> indegree = new HashMap();
        Set<TreeNode> set = new HashSet();
        
        for (int[] des : descriptions) {
            int parent= des[0], child = des[1], isLeft = des[2];
            TreeNode parentNode;
            if (!map.containsKey(parent)) {
                parentNode = new TreeNode(parent);
                map.put(parent, parentNode);
            }
            parentNode = map.get(parent);
            
            TreeNode childNode;
            if (!map.containsKey(child)) {
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            childNode = map.get(child);
            indegree.put(childNode, indegree.getOrDefault(childNode, 0) + 1);
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            set.add(childNode);
            set.add(parentNode);
        }
        
        for (TreeNode node : set) {
            if (indegree.getOrDefault(node, 0) == 0) {
                return node;
            }
        }
        
        return null;
    }
}