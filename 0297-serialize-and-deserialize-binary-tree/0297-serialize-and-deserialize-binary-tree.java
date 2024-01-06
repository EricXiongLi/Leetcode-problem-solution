/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder res = new StringBuilder();
        res.append(root.val);
        res.append(",");
        res.append(serialize(root.left));
        res.append(",");
        res.append(serialize(root.right));
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return des(q);
    }
    
    public TreeNode des(Queue<String> q) {
        String cur = q.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = des(q);
        root.right = des(q);
        return root;
    }
}


