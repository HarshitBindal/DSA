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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        int r = preorder[0];
        TreeNode root = new TreeNode(r);
        int idx = 0;
        int n = preorder.length;
        int leftN = preorder[1];
        for(int i=0; i<postorder.length; i++){
            if(postorder[i] == leftN){
                idx = i+1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(postorder, 0, idx));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, idx+1, n), Arrays.copyOfRange(postorder, idx, n));
        return root;
    }
}