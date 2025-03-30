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
        StringBuilder sb = new StringBuilder("");
        helper(sb, root);
        return sb.toString().trim();
    }

    private void helper(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append("null ");
            return;
        }
        sb.append(String.valueOf(root.val)).append(" ");
        helper(sb, root.left);
        helper(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper2(q);
    }

    private TreeNode helper2(Queue<String> q){
        if(q.isEmpty()){
            return null;
        }
        String val = q.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(q);
        node.right = helper2(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));