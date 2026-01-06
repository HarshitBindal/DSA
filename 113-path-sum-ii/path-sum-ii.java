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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, res, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode node, int targetSum, List<List<Integer>> res,
    List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        if(node.val==targetSum && node.left==null && node.right==null){
            res.add(new ArrayList<>(list));
        }
        helper(node.left, targetSum-node.val, res, list);
        helper(node.right, targetSum-node.val, res, list);
        list.remove(list.size()-1);
    }
}