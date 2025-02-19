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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.addLast(root);
        boolean rev = false;
        while(!q.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                if(!rev){
                    TreeNode curr = q.pollFirst();
                    currLevel.add(curr.val);
                    if(curr.left != null) q.addLast(curr.left);
                    if(curr.right != null) q.addLast(curr.right);
                }
                else {
                    TreeNode curr = q.pollLast();
                    currLevel.add(curr.val);
                    if(curr.right != null) q.addFirst(curr.right);
                    if(curr.left != null) q.addFirst(curr.left);
                }
            }               
            ans.add(currLevel);
            rev = !rev;
        }
        return ans;
    }
}