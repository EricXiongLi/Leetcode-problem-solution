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
class Node {
    TreeNode root;
    int pos;
    
    public Node(TreeNode root, int pos) {
        this.root = root;
        this.pos = pos;
    }
}

class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) return res;
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            TreeNode cur = curNode.root;
            int curPos = curNode.pos;
            map.computeIfAbsent(curPos, v -> new ArrayList<Integer>()).add(cur.val);
            if (cur.left != null) {
                q.offer(new Node(cur.left, curPos - 1));
            }
            if (cur.right != null) {
                q.offer(new Node(cur.right, curPos + 1));
            }
        }
        
        for (List<Integer> ls : map.values()) {
            res.add(ls);
        }
        return res;
    }
}